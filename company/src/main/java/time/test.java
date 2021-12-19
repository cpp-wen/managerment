package time;

import java.util.Date;

import POJO.FatherPOJO;

/**
 * @description:
 * @author:maidang
 * @date:2021/12/10
 **/
public class test {

	public static void main(String[] args) {
		//毫秒
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		System.out.println(date);
		FatherPOJO fatherPOJO=new FatherPOJO();
		int page=1;
		fatherPOJO.setCount(page);
		System.out.println(fatherPOJO.getCount());
		page++;
		System.out.println(fatherPOJO.getCount());
		System.out.println(l);
	}


}
