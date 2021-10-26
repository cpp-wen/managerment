package POJO;

import lombok.Data;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/04
 **/
@Data
public class UserTo {

  private String fromString;
  private Long fromLong;

  public UserTo() {
  }

  public UserTo(String fromString, Long fromLong) {
    this.fromString = fromString;
    this.fromLong = fromLong;
  }
}

