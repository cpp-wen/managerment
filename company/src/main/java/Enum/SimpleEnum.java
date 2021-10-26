package Enum;

/**
 * @description:
 * @author:maidang
 * @date:2021/09/27
 **/
public enum SimpleEnum {
  enum1("1","1"),
  enum2("2","2")
  ;

  SimpleEnum(String code, String desc) {
	this.code = code;
	this.desc = desc;
  }

  private String code;
  private String desc;
}
