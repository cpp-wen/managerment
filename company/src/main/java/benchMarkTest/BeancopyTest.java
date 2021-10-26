package benchMarkTest;

import com.alibaba.fastjson.JSON;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.RunnerException;

import java.util.concurrent.TimeUnit;

import POJO.JsonFrom;
import POJO.JsonTo;
import beanCopyUtil.BeanUtils;

/**
 * @description:对象拷贝性能测试
 * @author:maidang
 * @date:2021/10/10
 **/
@BenchmarkMode(Mode.Throughput)
@Measurement(iterations = 2, time = 6, timeUnit = TimeUnit.SECONDS)
@Threads(4)
@Fork(2)
@Warmup(iterations = 1)
@State(value = Scope.Benchmark)
public class BeancopyTest {


  public static void main(String[] args) throws RunnerException {
//	Options opt = new OptionsBuilder()
//		.include(BeancopyTest.class.getSimpleName())
//		.result("result2.json")
//		.resultFormat(ResultFormatType.JSON).build();
//
//	new Runner(opt).run();
	jsonCopy();
	orikaTest();
  }

  /**
   * json性能对比
   */
  @Benchmark
  public static void jsonCopy() {
	System.out.println(System.currentTimeMillis());
	JsonFrom init = JsonFrom.init();
	String jsonString = JSON.toJSONString(init);
	JsonTo jsonTo = JSON.parseObject(jsonString, JsonTo.class);
	System.out.println(System.currentTimeMillis());
  }

  /**
   * orika性能对比
   */
  @Benchmark
  public static void orikaTest() {
	System.out.println(System.currentTimeMillis());
	JsonFrom init = JsonFrom.init();
	JsonTo jsonTo = BeanUtils.mapObjects(init, JsonTo.class);
	System.out.println(System.currentTimeMillis());
  }


  /**
   * mapStruct状态对比
   */
  private static void mapStructTest(){

  }




}
