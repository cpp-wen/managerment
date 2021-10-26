package debug;

import java.util.stream.IntStream;

/**
 * @description:
 * @author:maidang
 * @date:2021/09/19
 **/
public class main {

  //debug Main函数
  public static void main(String[] args) {
//    testArray();
	testStream();
  }

  //test array
  private static void testArray(){
	for (int i = 0; i < 10; i++) {
	  example a=new example();
	  a.a=1;
	  a.a=2;
	}
  }
  static class  example{
    int a;
    int b;
  }
  private static void testStream(){
    int []result = IntStream.of(10,87,20,48,79,12,79)
		// 两个流 转换为一个流
		// .flatMap()
		.map(e->streamExample(e))
		.filter(e -> e>30)
		.distinct()
		.sorted()
		.toArray();
  }

  private static int streamExample(int a){
    int b =  a+ 2;
    return b;
  }

}
