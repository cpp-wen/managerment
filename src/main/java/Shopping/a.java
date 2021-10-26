package Shopping;

import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author:maidang
 * @date:2021/04/29
 **/
public class a {

  public static void main(String[] args) {
    JSONObject
        tcOrderExtendExtra=JSONObject.parseObject("{\"extend_version\":3,\"USE_NEW_SNAPSHOT\":\"1\",\"ENABLE_ACROSS_SHOP_VERIFY\":1,\"PRRINCIPAL_CERT_TYPE\":0,\"OUT_ORDER_EXPIRE_TIME\":\"1619754216911\",\"IS_NEW_CROSS_BORDER_TARIFF_STRATEGY\":\"false\",\"WEAPP_TRADE_MODULE_STATUS\":0,\"PARCEL_ARRIVE_START_TIME\":\"1619740800000\",\"IS_SPLIT_STOCK_DEDUCT\":true,\"BRAND_CERT_TYPE\":0,\"FEE_MIGRATE_CHARGE_BY_TC\":\"true\",\"STOCK_DEDUCT_SCENE\":\"1\",\"FISSION_TICKET_NUM\":0,\"WECHAT_SYNC_SHOPPING_LIST\":0,\"AD_CPS_SHOP\":0,\"CREATE_BY_NEW_TABLE\":\"1\",\"RISK_CONTROL_DOWNGRADED\":\"true\",\"USE_STORED_CUSTOMER_DISCOUNT\":\"false\",\"PARCEL_ARRIVE_END_TIME\":\"1619755200000\",\"RISK_QUERY_PARAM_PAY_LOAD\":\"{\\\"activity_type\\\":\\\"1\\\"}\",\"IS_NEED_DELIVERY_ORDER\":\"1\"}");
    String parcelArriveStartTime = tcOrderExtendExtra.getString("PARCEL_ARRIVE_END_TIME");
    System.out.println(parcelArriveStartTime);
  }
}
