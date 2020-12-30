package cn.dyaoming.demo.poi;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import freemarker.template.Configuration;
import freemarker.template.Template;


public class PoiUtil {
    private static Logger logger = Logger.getLogger(PoiUtil.class.getName());



    public static void main(String[] args) {
        try {
        // 设定Excel文件所在路径
        String excelFileName = args[0];
        // 读取Excel文件内容
        List<TableVo> readResult = readExcel(excelFileName);
        Map<String,List<TableVo>> mapVo = readResult.stream().collect(Collectors.groupingBy(f->f.getTableName()));
        List<Map> vos = new ArrayList<>();  
        
        for(Entry<String, List<TableVo>> entrySet :mapVo.entrySet()){
            Map map = new HashMap<>();
            map.put("tableName", entrySet.getKey());
            map.put("cloumns",entrySet.getValue());
            vos.add(map); 
        }
        
        //指定路径的第二种方式，我的路径是C：/a.ftl
        Configuration cfg=new Configuration();
        cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")));
        cfg.setDefaultEncoding("UTF-8");
        //输出文档路径及名称
        File outFile = new File(args[1]);
        
      //以utf-8的编码读取ftl文件
        Template template = cfg.getTemplate("table.ftl", "UTF-8");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "gb2312"), 10240);
        Map data = new HashMap<>();
        data.put("vos", vos);
        template.process(data, out);
        out.close();
        }catch(Exception e) {
            
        }

    }



    /**
     * 读取Excel文件内容
     * 
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public static List<TableVo> readExcel(String fileName) {

        Workbook workbook = null;
        FileInputStream inputStream = null;

        try {
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            // 获取Excel文件
            File excelFile = new File(fileName);
            if (!excelFile.exists()) {
                logger.warning("指定的Excel文件不存在！");
                return null;
            }

            // 获取Excel工作簿
            inputStream = new FileInputStream(excelFile);
            workbook = getWorkbook(inputStream, fileType);

            // 读取excel中的数据
            List<TableVo> resultDataList = parseExcel(workbook);

            return resultDataList;
        } catch (Exception e) {
            logger.warning("解析Excel失败，文件名：" + fileName + " 错误信息：" + e.getMessage());
            return null;
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                logger.warning("关闭数据流出错！错误信息：" + e.getMessage());
                return null;
            }
        }
    }

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";



    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     * 
     * @param inputStream 读取文件的输入流
     * @param fileType 文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }



    /**
     * 解析Excel数据
     * 
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private static List<TableVo> parseExcel(Workbook workbook) {
        List<TableVo> resultDataList = new ArrayList<>();
        // 解析sheet
        for(int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);
            if (null == firstRow) {
                logger.warning("解析Excel失败，在第一行没有读取到任何数据！");
            }

            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for(int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);

                if (null == row) {
                    continue;
                }

                TableVo resultData = convertRowToData(row);
                if (null == resultData) {
                    logger.warning("第 " + row.getRowNum() + "行数据不合法，已忽略！");
                    continue;
                }
                resultDataList.add(resultData);
            }
        }

        return resultDataList;
    }



    /**
     * 将单元格内容转换为字符串
     * 
     * @param cell
     * @return
     */
    private static String convertCellValueToString(Cell cell) {
        if (cell == null) { return null; }
        String returnValue = null;
        switch(cell.getCellType()) {
            case NUMERIC: // 数字
                Double doubleValue = cell.getNumericCellValue();

                // 格式化科学计数法，取一位整数
                DecimalFormat df = new DecimalFormat("0");
                returnValue = df.format(doubleValue);
                break;
            case STRING: // 字符串
                returnValue = cell.getStringCellValue();
                break;
            case BOOLEAN: // 布尔
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;
            case BLANK: // 空值
                break;
            case FORMULA: // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR: // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }



    /**
     * 提取每一行中需要的数据，构造成为一个结果数据对象
     * 当该行中有单元格的数据为空或不合法时，忽略该行的数据
     *
     * @param row 行数据
     * @return 解析后的行数据对象，行数据错误时返回null
     */
    private static TableVo convertRowToData(Row row) {
        TableVo resultData = new TableVo();
        Cell cell;
        int cellNum = 1;
        // 获取表名
        cell = row.getCell(cellNum++);
        String tableName = convertCellValueToString(cell);
        resultData.setTableName(tableName);
        // 获取字段名
        cell = row.getCell(cellNum++);
        String cloumnCode = convertCellValueToString(cell);
        resultData.setCloumnCode(cloumnCode);
        // 获取字段类型
        cell = row.getCell(cellNum++);
        String type = convertCellValueToString(cell);
        resultData.setType(type);
        // 获取是否为空
        cell = row.getCell(cellNum++);
        String isNull = convertCellValueToString(cell);
        resultData.setIsNull(isNull);
        // 获取字段说明
        cell = row.getCell(cellNum++);
        String desc = convertCellValueToString(cell);
        resultData.setDesc(desc);
        return resultData;
    }
    
    public static class TableVo {
        
        private String tableName;
        private String cloumnCode;
        private String type;
        private String isNull;
        private String desc;
        public String getTableName() {
            return tableName;
        }
        public void setTableName(String tableName) {
            this.tableName = tableName;
        }
        public String getCloumnCode() {
            return cloumnCode;
        }
        public void setCloumnCode(String cloumnCode) {
            this.cloumnCode = cloumnCode;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public String getIsNull() {
            return isNull;
        }
        public void setIsNull(String isNull) {
            this.isNull = isNull;
        }
        public String getDesc() {
            return desc;
        }
        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
