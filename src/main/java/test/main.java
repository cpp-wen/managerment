package test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:maidang
 * @date:2021/09/12
 **/
public class main {

  public static void main(String[] args) throws ExecutionException {

    //guava本地测试
	LoadingCache<Integer, String> test = CacheBuilder.newBuilder()
		.maximumSize(1000)
		.expireAfterWrite(10, TimeUnit.MINUTES)
		.build(
			new CacheLoader<Integer, String>() {

			  @Override
			  public String load(Integer integer) throws Exception {
				return createTest(integer);
			  }
			});
	System.out.println(test.get(1));
	System.out.println(test.get(1));



  }

  public static String createTest(Integer integer){
	System.out.println("调用了一遍");
    return String.valueOf(integer);
  }

}
