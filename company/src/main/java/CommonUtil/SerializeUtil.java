package CommonUtil;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/01
 **/
public class SerializeUtil {

  static final String REPLACE_CHAR = "*";
  //环绕脱敏
  public static String around(String str, int left, int right) {
	if (str == null || (str.length() < left + right + 1)) {
	  return str;
	}
	String regex = String.format("(?<=\\w{%d})\\w(?=\\w{%d})", left, right);
	return str.replaceAll(regex, REPLACE_CHAR);
  }

}
