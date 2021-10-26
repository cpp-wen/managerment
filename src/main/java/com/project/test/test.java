package com.project.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author:maidang
 * @date:2020/12/24
 **/
public class test {

  public static void main(String[] args) {

    System.out.println(statusMapping);
    HashMap<String, String> hashMap=new HashMap<>();
    System.out.println(hashMap.get("12"));
  }
  private static Map<Integer, String> statusMapping = new HashMap() {
    {
      put(1, "wait_seller_confirm_apply");
      put(2, "refund_processing");
      put(10, "wait_buyer_modify");
      put(20, "wait_buyer_return_goods");
      put(30, "wait_seller_confirm_receive");
      put(40, "seller_refuse_apply");
      put(45, "wait_buyer_confirm_goods");
      put(50, "refund_close");
      put(60, "refund_success");
    }
  };

}
