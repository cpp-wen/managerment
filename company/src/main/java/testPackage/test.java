package testPackage;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

import POJO.ChildPOJO;

/**
 * @description:
 * @author:maidang
 * @date:2021/09/28
 **/
public class test {



  public static void testString(){
    String a= "18057441398";
    a= StringUtils.leftPad(a, 3);
	System.out.println(a);
  }

  static final String  REPLACE_CHAR = "*";

  public static String around(String str, int left, int right) {

	if (str == null || (str.length() < left + right + 1)) {
	  return str;
	}
	String regex = String.format("(?<=\\w{%d})\\w(?=\\w{%d})", left, right);
	return str.replaceAll(regex, REPLACE_CHAR);
  }


  public static String pre(String str,int left){
	if (str == null || (str.length() < left + 1)) {
	  return str;
	}
	String regex = String.format("(?<=\\w{%d})\\w", left);
	System.out.println(regex);
	return str.replaceAll(regex, REPLACE_CHAR);
  }
  public static String end(String str,int end){
	if (str == null || (str.length() < end + 1)) {
	  return str;
	}
	String regex = String.format("\\w(?=\\w{%d})", end);
	System.out.println(regex);
	return str.replaceAll(regex, REPLACE_CHAR);
  }
  public static String util(String name,int left,int right,String replace){
    return StringUtils.left(name,left).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(name, right), StringUtils.length(name), "*"), "***"));
  }
  public static String address(String address){
	String regex = String.format("[A-Za-z0-9]+");
	return address.replaceAll(regex,"*");
  }
  public static void main(String[] args) {
//	System.out.println(address("那押解189号205A楼"));
//	System.out.println(StringUtils.left("18057441398", 1));
//	String name = StringUtils.leftPad("caopeng",1,"*");
//	System.out.println(name.substring(1));
//	Long a =10L;
//	Integer b =10;
//	System.out.println(Objects.equals(a,b));
//	System.out.println(Objects.equals(a,b) );
//	testTax();
	  testjsonString();
  }

  public void pojoTest(){
	ChildPOJO childPOJO=new ChildPOJO();
	childPOJO.getUserName();
  }

  public static void testTax(){
	  System.out.println(new BigDecimal("109.01").multiply(new BigDecimal(100)));
	  Long jisuan = 21562L/5;
	  System.out.println(jisuan);
	  long a=209L;
	  double aa= a;
  }

  public static void testjsonString(){
	  int a  []=new int[]{2,3,4};
	  String s = JSON.toJSONString(a);
	  JSONObject jsonObject = JSON.parseObject(s);
	  System.out.println(jsonObject);

  }

}
