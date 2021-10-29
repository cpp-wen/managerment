package jsonUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/01
 **/
@Slf4j
public class main {

  public static void main(String[] args) {
//    JsonPoJo poJo=JsonPoJo.builder().age(1L).name("name").build();
    JsonPoJo poJo = new JsonPoJo();
    poJo.setAge(1L);
    poJo.setNickName("caopeng");
    poJo.setUserAge("");
    log.info("value:{}",poJo);
    String pojoString = FastJsonUtil.bean2Json(poJo);
    System.out.println(pojoString);

  }

}
