package POJO;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/04
 **/
@Data
@ToString
public class JsonFrom {
  private String jsonString;
  private Integer jsonInteger;
  private int jsonInt;
  private Long jsonLong;
  //类型不一样
  private UserFrom jsonUser;

  public JsonFrom(String jsonString, Integer jsonInteger, int jsonInt, Long jsonLong,
				  UserFrom jsonUser) {
	this.jsonString = jsonString;
	this.jsonInteger = jsonInteger;
	this.jsonInt = jsonInt;
	this.jsonLong = jsonLong;
	this.jsonUser = jsonUser;
  }

  public JsonFrom() {
  }

  public static JsonFrom init(){
	JsonFrom jsonFrom = new JsonFrom();
	jsonFrom.setJsonString("1");
	jsonFrom.setJsonInteger(1);
	jsonFrom.setJsonInt(1);
	jsonFrom.setJsonLong(1L);
	jsonFrom.setJsonUser(new UserFrom("1",1L));
	return jsonFrom;
  }
}
