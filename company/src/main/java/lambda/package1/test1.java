package lambda.package1;

import java.util.function.Function;

import javax.swing.*;

/**
 * @description:
 * @author:maidang
 * @date:2021/12/19
 **/
public class test1 {
 Function<Long,Boolean> a = x->x>1;

	public static void main(String[] args) {
		ThreadLocal.withInitial(()->1000);
		Runnable test1 = ()-> System.out.println("hello");
		test1.run();
		JButton jButton=new JButton();
		jButton.addActionListener(event-> System.out.println(event.getActionCommand()));
	}
}
