package jsonUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @description:fastjson工具类
 * @author:maidang
 * @date:2021/09/27
 **/
public class FastJsonUtil {
  public  static String bean2Json(Object obj){
    return JSON.toJSONString(obj);
  }
  public static JSONObject jsonString2JsonObject(String object){
    return JSON.parseObject(object);
  }
  public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
	return JSON.parseObject(jsonStr, objClass);
  }



}
