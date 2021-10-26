import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * @description:
 * @author:maidang
 * @date:2021/01/06
 **/
public class test {

  public static void main(String[] args) throws Exception {
   // System.out.println("{\"extend_version\":9,\"USE_NEW_SNAPSHOT\":\"1\",\"PRRINCIPAL_CERT_TYPE\":3,\"IS_SPLIT_STOCK_DEDUCT\":true,\"BRAND_CERT_TYPE\":99,\"FEE_MIGRATE_CHARGE_BY_TC\":\"true\",\"IS_MERGE_PREPAY\":\"0\",\"CREATE_BY_NEW_TABLE\":\"1\",\"USE_STORED_CUSTOMER_DISCOUNT\":\"false\",\"SOURCE_CHANNEL\":\"0\",\"IS_BOS_FLOW\":\"false\",\"RISK_CONTROL_SEQ\":\"1704228285972487\",\"ENABLE_ACROSS_SHOP_VERIFY\":1,\"IS_NEW_CROSS_BORDER_TARIFF_STRATEGY\":\"false\",\"STOCK_DEDUCT_RESULT\":\"8\",\"WEAPP_TRADE_MODULE_STATUS\":1,\"WEAPP_TRADE_MODULE_TICKET\":0,\"BIZ_ORDER_ATTRIBUTE\":\"{\\\"MARKETING_CHANNEL\\\":\\\"directSeller\\\",\\\"ACCOUNTING_STATUS\\\":\\\"0\\\"}\",\"STOCK_DEDUCT_SCENE\":\"1\",\"FREIGHT_INSURANCE_FREE\":\"0\",\"FISSION_TICKET_NUM\":0,\"WECHAT_SYNC_SHOPPING_LIST\":1,\"AD_CPS_SHOP\":0,\"STOCK_DEDUCT_RESULT_TIME\":\"1625278770667\",\"WX_SYNC_SUCCESS\":\"1\"}");
//    List<String> name=new ArrayList<String>();
//    for (int i = 0; i <120000; i++) {
//      name.add(NameUtils.getCnName());
//    }
//    List<String> newname=name.stream().distinct().collect(Collectors.toList());
//    for (int i = 0; i <newname.size(); i++) {
//      System.out.println(newname.get(i));
//    }
//    String muban="https://h5.youzan.com/wscgoods/detail-snapshot?alias={alias}&pageType=wsc-goods-snapshot&kdtId=${kdt_id}&orderNo=${order_no}&goodsId=${goods_id}&snapKey=${snap_key}&itemId=${item_id}";
//    System.out.println(muban.replaceAll("\\{alias}", "1"));
//    System.out.println(muban);
//    try {
//      throw new NullPointerException();
//    }catch (Exception e){
//      if(e instanceof NullPointerException){
//        System.out.println("hello");
//      }else{
//        System.out.println("error");
//      }
//    }
//    long l = System.currentTimeMillis();
//    for (int i = 0; i < 20; i++) {
//      try {
//        if(i==2){
//          throw  new Exception();
//        }
//      }catch (Exception e){
//        System.out.println("yes");
//      }
//      System.out.println(i);
//    }
//    String routValue="head_kdt_id";
//    String routeValueField ="head_kdt_id";
//    String idField="order_no";
//    String idValue="订单号";
//    String querytmpl = "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"%s\":\"%s\"}},{\"term\":{\"%s\":\"%s\"}}],\"should\":[],\"must_not\":[]}},\"from\":0,\"size\":\"10\"}";
//    System.out.println(String.format(querytmpl, routeValueField, routValue, idField, idValue));
//    String orderNo="E20210902123419092004165";
//    String substring = orderNo.substring(orderNo.length() - 8);
//
//    System.out.println(
//        unCompress("H4sIAAAAAAAAAK2Rz07bQBDG7zzFyKcEySZplR5SAlJVKiFoL3C0FFn2JKzkzJrdccFFPbVFnKCt\n"
//                   + "qh7ggMQBjnBACAgSL4MDfYuusyGOirh1D/tvZr6d77eu6065EMpeIgmJV7MEm+CshEok/E7EjMqZ\n"
//                   + "AhOnjug2zQ4ANzFcwsxkOcNzomSIWtsScxthBzSuf5DQgijgwDOHNsl5j+Ub0V0kxi6qSnW+WfNJ\n"
//                   + "dKBic+egVoUtn/yhJoBfTAo5VQSdINbo02cTpZkZ0Bxwqo16HR5OjvO9H/np1eD0l1WzL44yWuA7\n"
//                   + "dd+xwvwoPVJllU6I5jsHef86/77byHe2//w8zLe/DQ7OB7/P7ve/3l0e5TdfJvTTxCzYZtFD42pZ\n"
//                   + "UrdSBde6DRU+iZWmZuFlrRijlv4xaIEKEjym6fzn3xl7CKKo3Vsf9lmAojSOh02ZmqdxeNZ2+WNj\n"
//                   + "kv2Lh9tDaIAFabGtZJqx54WpUoUPo/BexLHQJbfJ92bhVQ2moVFym4Z6SY3XlNwAwo2CjJfJ9FNA\n"
//                   + "HqsgQk9nFHofX3hvMQ6yhc0QExaSKtXXz9H9C2ZjBp0AAwAA"));

//    Preconditions.checkArgument(StringUtils.isNotBlank("")
//                                || StringUtils.isNotBlank("21312"),
//                                "收货人联系方式必不能为空");
  }

  public static final String unCompress(String compressedStr) {
    if (compressedStr == null) {
      return null;
    }
    ByteArrayOutputStream out = null;
    ByteArrayInputStream in = null;
    GZIPInputStream gin = null;
    String decompressed = null;
    try {
      byte[] compressed = new BASE64Decoder().decodeBuffer(compressedStr);
      out = new ByteArrayOutputStream();
      in = new ByteArrayInputStream(compressed);
      gin = new GZIPInputStream(in);
      byte[] buffer = new byte[1024];
      int offset = -1;
      while((offset = gin.read(buffer)) != -1) {
        out.write(buffer, 0, offset);
      }
      decompressed = out.toString("UTF-8");
    } catch (Exception e) {
      decompressed = compressedStr;
    } finally {
      if (gin != null) {
        try {
          gin.close();
        } catch (IOException e) {
        }
      }
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
        }
      }
    }
    return decompressed;
  }
}
