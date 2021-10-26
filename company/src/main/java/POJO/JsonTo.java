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
public class JsonTo {
  private String jsonString;
  private Integer jsonInteger;
  private int jsonInt;
  private Long jsonLong;
  //类型变了
  private UserTo jsonUser;

  public JsonTo(String jsonString, Integer jsonInteger, int jsonInt, Long jsonLong,
                UserTo jsonUser) {
    this.jsonString = jsonString;
    this.jsonInteger = jsonInteger;
    this.jsonInt = jsonInt;
    this.jsonLong = jsonLong;
    this.jsonUser = jsonUser;
  }

  public JsonTo() {
  }
  public static JsonTo init(){
    JsonTo jsonTo = new JsonTo();
    jsonTo.setJsonString("1");
    jsonTo.setJsonInteger(1);
    jsonTo.setJsonInt(1);
    jsonTo.setJsonLong(1L);
    jsonTo.setJsonUser(new UserTo("1",1L));
    return jsonTo;
  }


}
