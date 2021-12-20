package lambda.package1;

import java.util.function.Predicate;

/**
 * @description:
 * @author:maidang
 * @date:2021/12/19
 **/
public interface IntPred {
	boolean test(Integer value);
	boolean test(Predicate<Integer> predicate);

	public static void main(String[] args) {

	}
}

