package ExceptionTest;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/01
 **/
public class main {

	public static void main(String[] args) {
		try {
			int a =10 /0;
		}catch (ArithmeticException e){
			throw new RuntimeException("test");
		}finally {
			System.out.println("caopeng");
		}
	}
	//

}
