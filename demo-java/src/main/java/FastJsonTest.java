import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class FastJsonTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String param = "{name:\"dyaoming1\",\"id\":\"410\",age:\"5\"}";
        String template = "{\"id\":\"410\",name:\"dyaoming1\",age:\"5\"}";
        System.out.println(checkInput(param, template));
    }



    private static Boolean checkInput(String param, String template) {
        JSONObject inMap = JSON.parseObject(param);
        JSONObject templateMap = JSON.parseObject(template);

        for(Map.Entry<String, Object> entry : templateMap.entrySet()) {
            if (inMap.getString(entry.getKey()) == null || !inMap.getString(entry.getKey()).equals(entry.getValue())) { return false; }
        }

        return true;
    }
}
