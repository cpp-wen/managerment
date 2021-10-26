package beanCopyUtil;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import POJO.JsonFrom;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/04
 **/
public class test {

  public static void main(String[] args) {
    //对象拷贝方案设计
	//1. json直接拷贝
	System.out.println(System.currentTimeMillis());
	JsonFrom init = JsonFrom.init();
	System.out.println(init);
	String jsonString = JSONObject.toJSONString(init);
	System.out.println(jsonString);
	Object o = JSONObject.parseObject(jsonString, Object.class);
	System.out.println(o);
	System.out.println(System.currentTimeMillis());
	HashMap<Long,List<Long>> hashMap=new HashMap<Long, List<Long>>();
	ArrayList<Long> objects = new ArrayList<Long>();
	objects.add(1L);
	hashMap.put(1L,objects);
	String jsonString1 = JSONObject.toJSONString(hashMap);
	System.out.println(jsonString1);




  }
}
