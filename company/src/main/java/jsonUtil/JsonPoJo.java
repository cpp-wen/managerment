package jsonUtil;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import lombok.Builder;
import lombok.Data;

/**
 * @description: jsonPOJO类
 * @author:maidang
 * @date:2021/10/01
 **/
@Data
@JSONType()
@Builder
public class JsonPoJo {

  private String name;
  private Long age;
  @JSONField(name = "user_age",serializeUsing = testSerialization.class)
  private String userAge;
  @JSONField(name = "nick_name")
  private String nickName;

  public JsonPoJo() {
  }

  public JsonPoJo(String name, Long age, String userAge, String nickName) {
    this.name = name;
    this.age = age;
    this.userAge = userAge;
    this.nickName = nickName;
  }
}
