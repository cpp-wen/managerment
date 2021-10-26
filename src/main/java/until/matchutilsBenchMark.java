package until;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description: 字段匹配工具
 * @author:maidang
 * @date:2021/07/28
 **/

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(8)
@Fork(2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class matchutilsBenchMark {

  public static void main(String[] args) throws RunnerException {
/*	Options option = new OptionsBuilder()
		.include(matchutilsBenchMark.class.getSimpleName())
		.output("/Users/coapeng/IdeaProjects/personal/managerment/Benchmark.json")
		.build();*/
	Options opt = new OptionsBuilder()
		.include(matchutilsBenchMark.class.getSimpleName())
		.result("Benchmark.json")
		.resultFormat(ResultFormatType.JSON).build();
	new Runner(opt).run();
  }

  public static String
	  GOODS_NEW_SNAPSHOT_TEMPLATE =
	  "https://h5.youzan.com/wscgoods/detail-snapshot?alias={alias}&pageType=wsc-goods-snapshot&kdtId={kdt_id}&orderNo={order_no}&goodsId={goods_id}&snapKey={snap_key}&itemId={item_id}";
  public static String
	  templace =
	  "https://h5.youzan.com/wscgoods/detail-snapshot?alias=${}&pageType=wsc-goods-snapshot&kdtId=${}&orderNo=${}&goodsId=${}&snapKey=${}&itemId=${}";

  @Benchmark
  public void replace() {
	for (int i = 0; i < 10; i++) {
	  String a = String.valueOf(i);
	  GOODS_NEW_SNAPSHOT_TEMPLATE.replace("{alias}", a).replace("{kdt_id}", a)
		  .replace("{order_no}", a).replace("{goods_id}", a).
		  replace("{snap_key}", a)
		  .replace("{item_id}", a);
	}
  }

  @Benchmark
  public void repalceAll() {
	for (int i = 0; i < 10; i++) {
	  String a = String.valueOf(i);
	  GOODS_NEW_SNAPSHOT_TEMPLATE.replaceAll("\\{alias}", a).replaceAll("\\{kdt_id}", a)
		  .replaceAll("\\{order_no}", a).replaceAll("\\{goods_id}", a).
		  replaceAll("\\{snap_key}", a)
		  .replaceAll("\\{item_id}", a);
	}
  }

  @Benchmark
  public void stringAdd() {
	for (int i = 0; i < 10; i++) {
	  String b = String.valueOf(i);
	  String
		  a =
		  "https://h5.youzan.com/wscgoods/detail-snapshot?alias=" + b
		  + "&pageType=wsc-goods-snapshot&kdtId=" + b + "&orderNo=" + b + "&goodsId=" + b
		  + "&snapKey=" + b + "&itemId=" + b;
	}
  }

  @Benchmark
  public void joinerWithKeyValue() {
	for (int i = 0; i < 10; i++) {
	  String b = String.valueOf(i);
	  Map<String, String> salary = Maps.newHashMap();
	  salary.put("alias", b);
	  salary.put("kdtid", b);
	  salary.put("orderNo", b);
	  salary.put("goodsId", b);
	  salary.put("snapKey", b);
	  salary.put("itemId", b);
	  String result = "https://h5.youzan.com/wscgoods/detail-snapshot?" + Joiner
		  .on(",").withKeyValueSeparator("&").join(salary);
	}
  }
}
