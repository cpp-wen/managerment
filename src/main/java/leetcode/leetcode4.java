package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:maidang
 * @date:2021/01/10
 **/
public class leetcode4 {

  public static void main(String[] args) {
    String a="{\"excludePayTool\":\"INSTALMENT\",\"IS_MEMBER\":\"true\",\"IS_USE_PARAM_PRICE\":\"1\",\"CREATE_DEVICE_ID\":\"8d7e93466f8701706e2b7ad358a741d5aa61fbf9\",\"CASHIER_ID\":\"12567649631\",\"CASHIER_NAME\":\"mature\",\"SHOP_ROLE\":\"2\",\"OWNER_ID\":\"0\",\"payTool\":\"MARK_PAY\",\"PARENT_KDT_ID\":\"91550590\",\"excludePayToolCode\":\"40\",\"IS_TOURIST_BUYER\":\"false\",\"TOTAL_PRICE\":\"{\\\"currentPrice\\\":14700,\\\"originPrice\\\":21100}\",\"OUTER_TRANSACTION_NO\":\"v210110211654000034\",\"FROM_CART\":\"false\",\"REAL_PAY_AMOUNT\":14700,\"DAOGOU\":\"{\\\"ch\\\":\\\"offline\\\",\\\"id\\\":\\\"9201477200\\\",\\\"name\\\":\\\"偲敏\\\",\\\"serviceSalesmanId\\\":\\\"9201477200\\\",\\\"serviceSalesmanKdtId\\\":\\\"91652388\\\",\\\"serviceSalesmanName\\\":\\\"偲敏\\\",\\\"storeKdtId\\\":\\\"91652388\\\"}\",\"INNER_TRANSACTION_NO\":\"210110211654000023\",\"BUYER_PHONE\":\"15024207081\",\"BUYER_NAME\":\"李\"}";
    System.out.println(a.length());
  }
  public List<String> summaryRanges(int[] nums) {
    List<String> res=new ArrayList<String>();
    if(nums.length==0){
      return res;
    }
    int pre=nums[0];
    for(int i=1;i<nums.length;i++){
      if(nums[i]!=nums[i-1]+1){
        StringBuilder str=new StringBuilder();
        if(nums[i-1]!=pre){
          str.append(""+pre+"->"+nums[i-1]);
          pre=nums[i];
        }else{
          str.append(""+pre);
        }
        res.add(str.toString());
      }
    }
    StringBuilder str=new StringBuilder();
    int length=nums.length;
    if(nums[nums.length-1]!=pre){
      str.append(""+pre+"->"+nums[length-1]);
    }else{
      str.append(""+pre);
    }
    res.add(str.toString());
    return res;
  }

}
