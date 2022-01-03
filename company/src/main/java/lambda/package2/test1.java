package lambda.package2;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author:maidang
 * @date:2021/12/19
 **/
public class test1 {

	public static void main(String[] args) {
		//test flatmap
		Stream.of(asList(1,2)).flatMap(numer->numer.stream()).collect(Collectors.toList());
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World!");
			}
		};
	}

	private static ArrayList<Integer> asList(Integer ... a) {
		return new ArrayList<Integer>();
	}

}
