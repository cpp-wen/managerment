package leetcode;

/**
 * @description:
 * @author:maidang
 * @date:2021/01/30
 **/
public class test {

  public static void main(String[] args) {
    String a[]=new String[]{"E20210127222709028900091",
        "E20210128152408026600137",
        "E20210128152324082300121",
        "E20210128212209003804209",
        "E20210128212101003804203",
        "E20210126162008070504269",
        "E20210128211932074704111",
        "E20210126162317082300083",
        "E20210126161718089704129",
        "E20210128031303062600039",
        "E20210128150931061704169",
        "E20210129020850087904135",
        "E20210128220943101504115",
        "E20210128220444013000121",
        "E20210126160424004900047",
        "E20210127220316005004181",
        "E20210129000134057100033",
        "E20210126155952071204129",
        "E20210126155730016600001",
        "E20210129015543082604143",
        "E20210129015133033304113",
        "E20210126154758006100097",
        "E20210128224752084804159",
        "E20210128204657092900055"};
    for (int i = 0; i < a.length; i++) {
      String test="select refund_no from rp_refund_fund where order_no= \"";
      String test2="\" and sharding_id=";
      String temp=a[i];
      String sharding = temp.substring(15,19);
      String finaall=test+temp+test2+sharding;
      System.out.println(finaall);
    }
  }

}
