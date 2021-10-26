package jsonUtil;


import com.alibaba.fastjson.JSONObject;

import POJO.User;

/**
 * @description: json性能测试
 * @author:maidang
 * @date:2021/09/27
 **/
public class JsonBenchTest {

  public static void main(String[] args) {
	User user = new User("name1","word");
	long x = System.currentTimeMillis();
	System.out.println(x);
	for (int i = 0; i < 10; i++) {
	  String s = FastJsonUtil.bean2Json(user);
	  JSONObject jsonObject = FastJsonUtil.jsonString2JsonObject(s);
	  System.out.println(jsonObject.getString("name"));

	  User user1 = FastJsonUtil.json2Bean(s, User.class);
	}
	System.out.println(System.currentTimeMillis()-x);
  }
}
