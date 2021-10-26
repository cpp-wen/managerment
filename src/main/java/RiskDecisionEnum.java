import java.io.Serializable;

/**
 * @description:
 * @author:maidang
 * @date:2021/01/22
 **/
public enum RiskDecisionEnum implements Serializable {
  /**
   * 通过
   */
  ACCEPT("ACCEPT"),
  /**
   * 人工审核(业务方可认为是通过)
   */
  REVIEW("REVIEW"),
  /**
   * 拒绝
   */
  REJECT("REJECT"),
  /**
   * 其他错误
   */
  ERROR("ERROR");

  private final String value;
  private RiskDecisionEnum(String value) {
    this.value = value;
  }
  public String getValue() {
    return this.value;
  }
}

