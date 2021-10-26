package POJO;

import lombok.Data;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/04
 **/
@Data
public class UserFrom {

  //@JSONField(serializeUsing = AddressSerialize.class)
  private String fromString;
  private Long fromLong;

  public UserFrom(String fromString, Long fromLong) {
	this.fromString = fromString;
	this.fromLong = fromLong;
  }

  public UserFrom() {
  }
}
