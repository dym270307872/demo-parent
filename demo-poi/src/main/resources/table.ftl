<!DOCTYPE html>  
<html>
<head>
    <title>数据字典</title>
	<style type="text/css">
        @page{size:210mm 148mm; margin:auto auto 5px 5px;}
        body {
            margin-left: 45px;
            margin-right: 45px;
            font-family: "SimSun";
            font-size: 12px;
        }
        table {
            margin: auto;
            width: 100%;
            border-collapse: collapse;
            border: 1px solid #444;
        }
        th,td {
            border: 1px solid #444;
            padding:5px;
        }
        .print_title { font-size:20px; font-color:black;  text-align:center;position:relative; margin-bottom:80px;margin-top:80px;}
        .print_title span { position:absolute; font-size:12px; right:0; bottom:0;}
        .column_title{ text-align:center;}

        @media print{
            　　.noprint{
                　　display:none
                　　}
        }
    </style>
</head>
<body>
<#list vos as vo>
<div id="container" name="container" style="margin:0px 0px 0px 5px;">
    <div class="print_title">
        <span>表名：${vo.tableName}</span>
    </div>
    <table width="960px" border="1" class="print_table">
        <tr>
            <td class="column_title" align="center">字段名</td>
			<td class="column_title" align="center">类型</td>
			<td class="column_title" align="center">允许为空</td>
			<td class="column_title" align="center">说明</td>
        </tr>
		<#list vo.cloumns as f>
		<tr>
			<td align="center">${f.cloumnCode}</td>
			<td align="center">${f.type}</td>
			<td align="center">${f.isNull}</td>
			<td align="center">${f.desc}</td>
			</tr>
		</#list>
        
    </table>
</div>
</#list>
</body>
</html>