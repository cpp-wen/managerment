

/**
 * @description:
 * @author:maidang
 * @date:2021/11/08
 **/
public class mainTest {

	public static void main(String[] args) {
		try {
			throw  new RuntimeException();
		}catch (RuntimeException e){
			System.out.println("yes test");
			throw new RuntimeException();
		}
	}

}
