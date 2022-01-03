package lambda.设计模式.行为形模式;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @description: 策略模式学生选择不同的文本输出策略进行文字输出
 * @author:maidang
 * @date:2022/01/02
 **/
public class Strategy {

	//Traditional Design patterns
	public void main() {
		Student student= new Student(new simpleTextFormat());
		student.test("text");
	}

	//Function Design patterns
	//for second or thirds argument, can replace function
	public void main2(){
		Student2 student2 = new Student2();
		student2.test2("text",(value)->value.length()>10,(value)->value);
	}


	public interface textFormat {

		boolean filter(String text);

		String format(String value);
	}


	class Student {

		textFormat textFormat;

		public Student(textFormat textFormat) {
			this.textFormat = textFormat;
		}

		public void test(String value) {
			if (textFormat.filter(value)) {
				System.out.println(textFormat.format(value));
			}
		}
	}

	class simpleTextFormat implements textFormat {

		@Override
		public boolean filter(String text) {
			return true;
		}

		@Override
		public String format(String value) {
			return value;
		}
	}

	class filterLengthTextFormat implements textFormat {

		@Override
		public boolean filter(String text) {
			if (text.length() > 10) {
				return true;
			}
			return false;
		}

		@Override
		public String format(String value) {
			return value+" Length > 10";
		}
	}

	class Student2{
		public void test2(String value, Predicate<String> predicate, Function<String,String> function){
			if(predicate.test(value)){
				System.out.println(function.apply(value));
			}
		}
	}
}
