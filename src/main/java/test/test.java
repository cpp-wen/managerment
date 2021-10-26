package test;

import lombok.extern.slf4j.Slf4j;
import test.test1.test2;

/**
 * @description:
 * @author:maidang
 * @date:2020/12/29
 **/
@Slf4j
public class test {

  private  Long number;
  public static void main(String[] args) {
    log.info("nihao");
    test2 test2=new test2();
  }
  public static int count(){
    System.out.println("123");
    return 0;
  }

}
