package jsonPathTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.jayway.jsonpath.JsonPath;

import java.util.HashMap;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/03
 **/
public class demo {

  private static String buildJsonString() {
	String jsonString = "{\n"
						+ "    \"store\": {\n"
						+ "        \"book\": [\n"
						+ "            {\n"
						+ "                \"category\": \"reference\",\n"
						+ "                \"author\": \"Nigel Rees\",\n"
						+ "                \"title\": \"Sayings of the Century\",\n"
						+ "                \"price\": 8.95\n"
						+ "            },\n"
						+ "            {\n"
						+ "                \"category\": \"fiction\",\n"
						+ "                \"author\": \"Evelyn Waugh\",\n"
						+ "                \"title\": \"Sword of Honour\",\n"
						+ "                \"price\": 12.99\n"
						+ "            },\n"
						+ "            {\n"
						+ "                \"category\": \"fiction\",\n"
						+ "                \"author\": \"Herman Melville\",\n"
						+ "                \"title\": \"Moby Dick\",\n"
						+ "                \"isbn\": \"0-553-21311-3\",\n"
						+ "                \"price\": 8.99\n"
						+ "            },\n"
						+ "            {\n"
						+ "                \"category\": \"fiction\",\n"
						+ "                \"author\": \"J. R. R. Tolkien\",\n"
						+ "                \"title\": \"The Lord of the Rings\",\n"
						+ "                \"isbn\": \"0-395-19395-8\",\n"
						+ "                \"price\": 22.99\n"
						+ "            }\n"
						+ "        ],\n"
						+ "        \"bicycle\": {\n"
						+ "            \"color\": \"red\",\n"
						+ "            \"price\": 19.95\n"
						+ "        }\n"
						+ "    },\n"
						+ "    \"expensive\": 10\n"
						+ "}\n";
	return jsonString;
  }

  public static String builderMainOrderInfo() {
	String mainOrderInfo = "{\n"
						   + "    \"mainOrderInfo\":{\n"
						   + "        \"orderId\":2830866041416974415,\n"
						   + "        \"kdtId\":63077,\n"
						   + "        \"orderNo\":\"E20210930165205017200045\",\n"
						   + "        \"state\":50,\n"
						   + "        \"stateDesc\":\"待发货\",\n"
						   + "        \"stateOld\":5,\n"
						   + "        \"orderType\":0,\n"
						   + "        \"buyWay\":28,\n"
						   + "        \"buyWayDesc\":\"E卡支付\",\n"
						   + "        \"buyerBuyWayDesc\":\"有赞E卡通\",\n"
						   + "        \"sellerBuyWayDesc\":\"有赞E卡通\",\n"
						   + "        \"closeReason\":\"\",\n"
						   + "        \"payType\":2,\n"
						   + "        \"payId\":\"2109301652050003520847\",\n"
						   + "        \"payState\":1,\n"
						   + "        \"stockState\":1,\n"
						   + "        \"activityType\":1,\n"
						   + "        \"orderGoodsType\":0,\n"
						   + "        \"logisticsType\":1,\n"
						   + "        \"bizTags\":{\n"
						   + "            \"normal\":true,\n"
						   + "            \"fx\":true,\n"
						   + "            \"purchase\":true,\n"
						   + "            \"edu\":true,\n"
						   + "            \"multiGoodsTypeModelType\":0,\n"
						   + "            \"salesModelType\":0,\n"
						   + "            \"fxModeType\":0\n"
						   + "        },\n"
						   + "        \"payTime\":\"2021-09-30 16:52:09\",\n"
						   + "        \"createTime\":\"2021-09-30 16:52:05\",\n"
						   + "        \"successTime\":\"1970-01-01 08:00:00\",\n"
						   + "        \"updateTime\":\"2021-09-30 16:53:23\",\n"
						   + "        \"closeTime\":\"1970-01-01 08:00:00\",\n"
						   + "        \"bizType\":1,\n"
						   + "        \"feedback\":0,\n"
						   + "        \"shopId\":0,\n"
						   + "        \"shopType\":0,\n"
						   + "        \"teamType\":0,\n"
						   + "        \"refundState\":0,\n"
						   + "        \"expressType\":0,\n"
						   + "        \"closeType\":0,\n"
						   + "        \"visible\":1,\n"
						   + "        \"tags\":{\n"
						   + "            \"MESSAGE_NOTIFY\":true,\n"
						   + "            \"IS_MEMBER\":true,\n"
						   + "            \"IS_SECURED_TRANSACTIONS\":true,\n"
						   + "            \"STOCK_DEDUCTED\":true,\n"
						   + "            \"IS_PAYED\":true\n"
						   + "        },\n"
						   + "        \"extra\":{\n"
						   + "            \"STOCK_DEDUCT_SCENE\":\"1\",\n"
						   + "            \"IS_PREPAY\":true,\n"
						   + "            \"INNER_TRANSACTION_NO\":\"2109301652090000770847\",\n"
						   + "            \"LC_HIGH_VER\":\"1\",\n"
						   + "            \"ORDER_FROM_METHOD\":\"create\",\n"
						   + "            \"WEAPP_TRADE_MODULE_STATUS\":1,\n"
						   + "            \"TOURIST\":\"YZ888141576199139328YZzEenGWGF\",\n"
						   + "            \"excludePayToolCode\":\"49,40\",\n"
						   + "            \"RISK_CONTROL_SEQ\":\"1712315807826051\",\n"
						   + "            \"USE_STORED_CUSTOMER_DISCOUNT\":\"false\",\n"
						   + "            \"IS_NEW_CROSS_BORDER_TARIFF_STRATEGY\":\"false\",\n"
						   + "            \"WEAPP_TRADE_MODULE_TICKET\":1,\n"
						   + "            \"OUTER_TRANSACTION_NO\":\"CPT210930165209000000\",\n"
						   + "            \"FEE_MIGRATE_CHARGE_BY_TC\":\"true\",\n"
						   + "            \"IS_MERGE_PREPAY\":\"0\",\n"
						   + "            \"extra\":\"\uD83E\uDD8A\",\n"
						   + "            \"IS_SPLIT_STOCK_DEDUCT\":true,\n"
						   + "            \"FISSION_TICKET_NUM\":0,\n"
						   + "            \"extraCustomerCardId\":\"10043800_2\",\n"
						   + "            \"BUYER_PHONE\":\"18758877478\",\n"
						   + "            \"BUYER_BENIFIT\":\"{\\\"level\\\":\\\"1_2\\\",\\\"type\\\":\\\"2\\\"}\",\n"
						   + "            \"IS_BOS_FLOW\":\"false\",\n"
						   + "            \"BRAND_CERT_TYPE\":4,\n"
						   + "            \"FROM_CART\":\"false\",\n"
						   + "            \"IS_USE_PARAM_PRICE\":\"0\",\n"
						   + "            \"AD_CPS_SHOP\":1,\n"
						   + "            \"extend_version\":6,\n"
						   + "            \"SOURCE_CHANNEL\":\"0\",\n"
						   + "            \"ENABLE_ACROSS_SHOP_VERIFY\":0,\n"
						   + "            \"IS_OFFLINE\":\"0\",\n"
						   + "            \"payTool\":\"ECARD\",\n"
						   + "            \"excludePayTool\":\"INSTALMENT,PRIOR_USE\",\n"
						   + "            \"USE_NEW_SNAPSHOT\":\"1\",\n"
						   + "            \"FANS\":\"{\\\"fansId\\\":12100758671,\\\"fansNickName\\\":\\\"\uD83E\uDD8A\\\",\\\"outerUserId\\\":\\\"oFgWmsMH75tb0n2dBWCdyje8jJY\\\",\\\"type\\\":1,\\\"youzanFansId\\\":694673301}\",\n"
						   + "            \"WECHAT_SYNC_SHOPPING_LIST\":1,\n"
						   + "            \"ORDER_TYPE\":\"0\",\n"
						   + "            \"REAL_PAY_AMOUNT\":1,\n"
						   + "            \"PRRINCIPAL_CERT_TYPE\":2,\n"
						   + "            \"FREIGHT_INSURANCE_FREE\":\"0\",\n"
						   + "            \"PREPAY_SUCCESS\":true,\n"
						   + "            \"PREPAY_RESULT\":{\n"
						   + "                \"cashierSign\":\"7C20763709F66D47F519751D897AFDAE\",\n"
						   + "                \"acquireOrder\":\"2109301652050003520847\",\n"
						   + "                \"cashierUrl\":\"https://cashier.youzan.com/pay/buyer?prepay_id=PT1712316140748808&cashier_sign=7C20763709F66D47F519751D897AFDAE&cashier_salt=1632991925646&partner_id=820000000058&from=trade-core\",\n"
						   + "                \"cashierSalt\":\"1632991925646\",\n"
						   + "                \"partnerId\":\"820000000058\",\n"
						   + "                \"prepayId\":\"PT1712316140748808\"\n"
						   + "            },\n"
						   + "            \"EXTERNAL_POINT_ID\":\"0\",\n"
						   + "            \"CREATE_BY_NEW_TABLE\":\"1\",\n"
						   + "            \"IS_POINTS_ORDER\":\"0\",\n"
						   + "            \"SHOP_TOPIC\":0,\n"
						   + "            \"IS_MEMBER\":\"true\",\n"
						   + "            \"BIZ_ORDER_ATTRIBUTE\":\"{\\\"SALESMAN_MSG\\\":\\\"{\\\\\\\"id\\\\\\\":107232038,\\\\\\\"name\\\\\\\":\\\\\\\"\uD83E\uDD8A\\\\\\\",\\\\\\\"phone\\\\\\\":\\\\\\\"18758877478\\\\\\\",\\\\\\\"shopId\\\\\\\":63077,\\\\\\\"shopName\\\\\\\":\\\\\\\"YZ微商城\\\\\\\"}\\\",\\\"MARKETING_CHANNEL\\\":\\\"directSeller\\\"}\",\n"
						   + "            \"OWNER_ID\":\"1\"\n"
						   + "        },\n"
						   + "        \"outBizNo\":\"E20210930165205017200045\",\n"
						   + "        \"confirmTime\":0,\n"
						   + "        \"expressTime\":0,\n"
						   + "        \"expiredTime\":1632997925405,\n"
						   + "        \"isRetailOrder\":false,\n"
						   + "        \"shopName\":\"YZ微商城\",\n"
						   + "        \"activityIdList\":[\n"
						   + "            0,\n"
						   + "            0\n"
						   + "        ],\n"
						   + "        \"messageNotify\":true,\n"
						   + "        \"headKdtId\":63077,\n"
						   + "        \"contractId\":2830866041416974414,\n"
						   + "        \"channelType\":0\n"
						   + "    },\n"
						   + "    \"paymentInfo\":{\n"
						   + "        \"kdtId\":63077,\n"
						   + "        \"orderNo\":\"E20210930165205017200045\",\n"
						   + "        \"pay\":1,\n"
						   + "        \"postage\":0,\n"
						   + "        \"realPay\":1,\n"
						   + "        \"isFreePostage\":0,\n"
						   + "        \"outerTransactionNumber\":\"\",\n"
						   + "        \"outerTransactionNumberList\":[\n"
						   + "            \"CPT210930165209000000\"\n"
						   + "        ],\n"
						   + "        \"innerTransactionNumberList\":[\n"
						   + "            \"2109301652090000770847\"\n"
						   + "        ],\n"
						   + "        \"phasePayments\":[\n"
						   + "            \n"
						   + "        ],\n"
						   + "        \"deductionPayments\":[\n"
						   + "            \n"
						   + "        ],\n"
						   + "        \"orderExtraPrices\":[\n"
						   + "            \n"
						   + "        ]\n"
						   + "    },\n"
						   + "    \"itemInfo\":[\n"
						   + "        {\n"
						   + "            \"orderNo\":\"E20210930165205017200045\",\n"
						   + "            \"itemId\":2830866041416974416,\n"
						   + "            \"realPay\":1,\n"
						   + "            \"goodsId\":1257201120,\n"
						   + "            \"goodsName\":\"郭越的实物000\",\n"
						   + "            \"goodsInfo\":\"{\\\"is_virtual\\\":0,\\\"purchaseRight\\\":false,\\\"bizMarkCode\\\":\\\"000000000000\\\",\\\"extraMap\\\":{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"ABILITY_MARK_CODES\\\":\\\"[20001,30002,10012,30007,10020,10022,10023,10021,10029]\\\",\\\"ITEM_UNIQ_ID\\\":\\\"100001\\\"},\\\"needCustomsCheck\\\":false,\\\"goods_no\\\":\\\"\\\",\\\"origin\\\":\\\"\\\",\\\"channel\\\":0,\\\"createType\\\":0,\\\"isCourse\\\":false,\\\"isCombo\\\":false,\\\"title\\\":\\\"郭越的实物000\\\",\\\"parentKdtId\\\":0,\\\"isPayGradeCard\\\":false,\\\"needCustomsPicture\\\":false,\\\"isHaiTao\\\":false,\\\"isSupportInstallment\\\":false,\\\"hasMultiSku\\\":false,\\\"extra\\\":{\\\"deliveryTempleId\\\":0,\\\"weight\\\":0.0},\\\"quota\\\":0,\\\"categoryList\\\":[\\\"其他\\\"],\\\"alias\\\":\\\"35wmciolig8qtq5\\\",\\\"joinLevelDiscount\\\":1,\\\"supportExchange\\\":false,\\\"needCustomsInfo\\\":false,\\\"isGiftCard\\\":false,\\\"isMemberCard\\\":false,\\\"buy_way\\\":1,\\\"goods_id\\\":1257201120,\\\"isKnowledge\\\":false,\\\"stock_deduct_mode\\\":0,\\\"soldStatus\\\":1,\\\"isFx\\\":false,\\\"isDisplay\\\":1,\\\"quotaType\\\":\\\"NO\\\",\\\"heavyContinued\\\":false,\\\"parentGoodsId\\\":0,\\\"points_price\\\":0,\\\"class2\\\":\\\"\\\",\\\"img_url\\\":\\\"https://img01.yzcdn.cn/upload_files/2021/09/17/FjMwPYPiAng89cCzNWqHMu0HrfLt.JPG\\\",\\\"class1\\\":0,\\\"mark\\\":0}\",\n"
						   + "            \"num\":1,\n"
						   + "            \"imgUrl\":\"https://img01.yzcdn.cn/upload_files/2021/09/17/FjMwPYPiAng89cCzNWqHMu0HrfLt.JPG\",\n"
						   + "            \"skuId\":37728935,\n"
						   + "            \"sku\":\"[]\",\n"
						   + "            \"skuCode\":\"\",\n"
						   + "            \"originUnitPrice\":1,\n"
						   + "            \"buyerMemo\":\"\",\n"
						   + "            \"feedback\":0,\n"
						   + "            \"csStatus\":0,\n"
						   + "            \"goodsRefund\":0,\n"
						   + "            \"postageRefund\":0,\n"
						   + "            \"unitPrice\":1,\n"
						   + "            \"payPrice\":1,\n"
						   + "            \"tags\":{\n"
						   + "                \"STOCK_DEDUCTED\":true\n"
						   + "            },\n"
						   + "            \"goodsType\":0,\n"
						   + "            \"snapShot\":\"c9fda98a989668e80366536801232c74\",\n"
						   + "            \"extra\":\"{\\\"DELIVER_TIME\\\":\\\"0\\\",\\\"STOCK_DEDUCT_SCENE\\\":\\\"0\\\",\\\"BIZ_ITEM_ATTRIBUTE\\\":\\\"{\\\\\\\"use_external_ticket_provider\\\\\\\":\\\\\\\"true\\\\\\\",\\\\\\\"EXTERNAL_TICKET\\\\\\\":\\\\\\\"0\\\\\\\"}\\\",\\\"BIZ_TRACE_POINT\\\":\\\"{\\\\\\\"extension\\\\\\\":{\\\\\\\"uuid\\\\\\\":\\\\\\\"027623d8-136d-f397-18c4-651498b0f088\\\\\\\",\\\\\\\"platform\\\\\\\":\\\\\\\"web\\\\\\\"},\\\\\\\"cartUpdateTime\\\\\\\":0,\\\\\\\"pageSource\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"cartCreateTime\\\\\\\":0}\\\",\\\"USED_PRO\\\":\\\"{\\\\\\\"activityId\\\\\\\":0,\\\\\\\"activityType\\\\\\\":\\\\\\\"1\\\\\\\"}\\\",\\\"orderItemExtraInTotal\\\":[],\\\"FX_MODE\\\":\\\"1\\\",\\\"POINTS_PRICE\\\":\\\"0\\\"}\",\n"
						   + "            \"isPresent\":false,\n"
						   + "            \"promotionInfo\":\"{\\\"activityId\\\":0,\\\"activityType\\\":\\\"1\\\"}\"\n"
						   + "        }\n"
						   + "    ],\n"
						   + "    \"buyerInfo\":{\n"
						   + "        \"kdtId\":63077,\n"
						   + "        \"orderNo\":\"E20210930165205017200045\",\n"
						   + "        \"buyerId\":461301932,\n"
						   + "        \"buyerPhone\":\"18758877478\",\n"
						   + "        \"customerType\":1,\n"
						   + "        \"customerId\":12100758671,\n"
						   + "        \"customerName\":\"\uD83E\uDD8A\",\n"
						   + "        \"tourist\":\"YZ888141576199139328YZzEenGWGF\",\n"
						   + "        \"outerUserId\":\"oFgWms-MH75tb0n2dBWCdyje8jJY\"\n"
						   + "    },\n"
						   + "    \"sourceInfo\":{\n"
						   + "        \"kdtId\":63077,\n"
						   + "        \"orderNo\":\"E20210930165205017200045\",\n"
						   + "        \"originSource\":\"{\\\"bookKey\\\":\\\"45326c97-86ae-4a34-a6ab-7323396d411c\\\",\\\"clientIp\\\":\\\"127.0.0.1\\\",\\\"fromThirdApp\\\":false,\\\"isOnlineOrder\\\":true,\\\"isReceiveMsg\\\":1,\\\"newSource\\\":\\\"{\\\\\\\"platformEnum\\\\\\\":\\\\\\\"WX\\\\\\\",\\\\\\\"wxEntranceEnum\\\\\\\":\\\\\\\"DIRECT_BUY\\\\\\\"}\\\",\\\"platform\\\":\\\"weixin\\\",\\\"seller\\\":\\\"\\\",\\\"tradeMarks\\\":[],\\\"userAgent\\\":\\\"Mozilla/5.0 (iPhone; CPU iPhone OS 14_5_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.13(0x18000d34) NetType/WIFI Language/zh_CN\\\"}\",\n"
						   + "        \"clientIp\":\"127.0.0.1\",\n"
						   + "        \"track\":\"\",\n"
						   + "        \"isOfflineOrder\":false,\n"
						   + "        \"orderSourceDTO\":{\n"
						   + "            \"platformEnum\":\"wx\",\n"
						   + "            \"wxEntranceEnum\":\"direct_buy\"\n"
						   + "        },\n"
						   + "        \"bizPlatform\":\"\"\n"
						   + "    },\n"
						   + "    \"orderAddressInfo\":{\n"
						   + "        \"kdtId\":63077,\n"
						   + "        \"orderNo\":\"E20210930165205017200045\",\n"
						   + "        \"receiverName\":\"郭越\",\n"
						   + "        \"receiverTel\":\"18758877478\",\n"
						   + "        \"deliveryCountry\":\"中国\",\n"
						   + "        \"deliveryProvince\":\"浙江省\",\n"
						   + "        \"deliveryCity\":\"杭州市\",\n"
						   + "        \"deliveryDistrict\":\"西湖区\",\n"
						   + "        \"deliveryStreet\":\"西溪路698号华泰创业园 有赞6-4D2-063\",\n"
						   + "        \"deliveryPostalCode\":\"\",\n"
						   + "        \"selfFetchInfo\":\"\",\n"
						   + "        \"addressExtra\":\"{\\\"areaCode\\\":\\\"330106\\\",\\\"lon\\\":120.09312414351916,\\\"lat\\\":30.26288486215556}\"\n"
						   + "    },\n"
						   + "    \"remarkInfo\":{\n"
						   + "        \"kdtId\":63077,\n"
						   + "        \"orderNo\":\"E20210930165205017200045\",\n"
						   + "        \"buyerMemo\":\"\"\n"
						   + "    },\n"
						   + "    \"promotionInfo\":{\n"
						   + "        \"pcOrderItemPrice\":[\n"
						   + "            {\n"
						   + "                \"unitPrice\":1,\n"
						   + "                \"totalPrice\":1,\n"
						   + "                \"originUnitPrice\":1,\n"
						   + "                \"num\":1,\n"
						   + "                \"orderNo\":\"E20210930165205017200045\",\n"
						   + "                \"itemId\":2830866041416974416,\n"
						   + "                \"present\":0,\n"
						   + "                \"goodsId\":1257201120,\n"
						   + "                \"kdtId\":63077,\n"
						   + "                \"shopId\":0,\n"
						   + "                \"skuId\":37728935,\n"
						   + "                \"extra\":\"{\\\"a\\\":759945868240,\\\"goodsType\\\":0,\\\"deliveryTemplateId\\\":0,\\\"fixedPostage\\\":0,\\\"editOriginPrice\\\":1,\\\"pointsPrice\\\":0,\\\"orderItemExtraInTotal\\\":[],\\\"salePrice\\\":1,\\\"channel\\\":0,\\\"virtualType\\\":0,\\\"extension\\\":{\\\"ITEM_UNIQ_ID\\\":\\\"100001\\\",\\\"use_external_ticket_provider\\\":\\\"true\\\",\\\"EXTERNAL_TICKET\\\":\\\"0\\\"}}\",\n"
						   + "                \"tags\":0\n"
						   + "            }\n"
						   + "        ],\n"
						   + "        \"pcOrderPriceChangeLog\":[\n"
						   + "            {\n"
						   + "                \"changeType\":\"ump_order\",\n"
						   + "                \"fieldName\":\"\",\n"
						   + "                \"oldValue\":0,\n"
						   + "                \"newValue\":0,\n"
						   + "                \"tag\":1,\n"
						   + "                \"detail\":\"{\\\"promotionType\\\":\\\"customerPostageFree\\\",\\\"promotionTypeId\\\":108,\\\"promotionTypeName\\\":\\\"会员包邮\\\",\\\"promotionId\\\":0,\\\"promotionAlias\\\":\\\"\\\",\\\"promotionTitle\\\":\\\"黄金会员VIP2\\\",\\\"promotionLevel\\\":\\\"ORDER\\\",\\\"prePay\\\":0,\\\"newPay\\\":0,\\\"decrease\\\":0,\\\"extra\\\":\\\"{\\\\\\\"level\\\\\\\":\\\\\\\"1_2\\\\\\\",\\\\\\\"type\\\\\\\":2}\\\"}\",\n"
						   + "                \"extra\":\"\"\n"
						   + "            },\n"
						   + "            {\n"
						   + "                \"changeType\":\"ump_postage\",\n"
						   + "                \"fieldName\":\"\",\n"
						   + "                \"oldValue\":0,\n"
						   + "                \"newValue\":0,\n"
						   + "                \"tag\":1,\n"
						   + "                \"detail\":\"{\\\"promotionType\\\":\\\"customerPostageFree\\\",\\\"promotionTypeId\\\":108,\\\"promotionTypeName\\\":\\\"会员包邮\\\",\\\"promotionId\\\":0,\\\"promotionTitle\\\":\\\"黄金会员VIP2\\\",\\\"promotionLevel\\\":\\\"ORDER\\\",\\\"prePay\\\":0,\\\"newPay\\\":0,\\\"extra\\\":\\\"{\\\\\\\"isOrderPostFree\\\\\\\":true}\\\"}\",\n"
						   + "                \"extra\":\"\"\n"
						   + "            }\n"
						   + "        ]\n"
						   + "    },\n"
						   + "    \"refundInfo\":{\n"
						   + "        \n"
						   + "    }\n"
						   + "}";
	return mainOrderInfo;
  }

  public static void main(String[] args) {
//	String s = buildJsonString();
//	String mainOrderInfo = builderMainOrderInfo();
//	String jsonMainOrderInfo = JSONObject.toJSONString(mainOrderInfo);
//	System.out.println(jsonMainOrderInfo);
//	List<String> value = JsonPath.read(s, "$.store.book[*].author");
//	System.out.println(value);
//	String read = (String)JsonPath.read(jsonMainOrderInfo, "$.mainOrderInfo.extra.BIZ_ORDER_ATTRIBUTE.SALESMAN_MSG");
//	Object read1 = JsonPath.read(read, "$.fansId");
//	System.out.println(read1);
//	System.out.println(read);
//	System.out.println(value);
//	fastJsonPath();
//	jsonPath();
	demoTest();
  }


  private static void fastJsonPath(){
	long l = System.currentTimeMillis();
	System.out.println(l);
	String s =buildJsonString();
	for (int i = 0; i < 10000; i++) {
	  JsonPath.read(s,"$.store.book[*].author");
	}
	long l1 = System.currentTimeMillis();
	System.out.println("fastJsonPath耗时等于"+(l1-l));

  }
  private static void jsonPath(){
	long l = System.currentTimeMillis();
	System.out.println(l);
	String s =buildJsonString();
	for (int i = 0; i < 10000; i++) {
	  JSONPath.read(s, "$.store.book[*].author");
	}
	long l1 = System.currentTimeMillis();
	System.out.println("jsonPath耗时等于"+(l1-l));
  }

  public static  void demoTest(){
	String a ="{\"emailList\":[\"123456@qq.com\"],\"invoiceDetailType\":\"itemDetail\",\"raiseType\":\"personal\",\"userName\":\"曹鹏\"}";
	JSONObject jsonObject=JSONObject.parseObject(a);
	Object userName = jsonObject.get("userName");
	JSONArray emailList = jsonObject.getJSONArray("emailList");
	Object read = JsonPath.read(a, "$.userName");
	for (Object o : emailList) {
	}
	jsonObject.put("userName","caopeng");
	HashMap<String,String> hashMap=new HashMap<>();
	hashMap.put("value",jsonObject.toJSONString());
	System.out.println(JSON.toJSON(hashMap));
	System.out.println(""+jsonObject.toJSONString());
  }
}
