package lambda.dailyLambda;

import java.util.function.Function;

/**
 * @description:
 * @author:maidang
 * @date:2022/01/04
 **/
public class functionDaily {

	//function 函数用来做逻辑判断
	public void judge(){
		Function<Integer, Integer> judge = errorCode -> errorCode > 1 ? 1 : 0;
		judge.apply(1);
	}


	//BiFunction 常用的用法 两个入参 一个结果
	//函数方法可以放入到枚举里面 可以一路透传到上下文里面
	//function可以结合泛型方法 ，生成代码返回值


//	public class StreamUtil {
//
//		private StreamUtil() {}
//
//		public static <T,R> List<R> map(List<T> dataList, Function<T,R> getData) {
//			if (CollectionUtils.isEmpty(dataList)) { return new ArrayList(); }
//			return dataList.stream().map(getData).collect(Collectors.toList());
//		}
//
//		public static<T,R> List<R> filterAndMap(List<T> dataList, Predicate<? super T> predicate , Function<T,R> getData) {
//			if (CollectionUtils.isEmpty(dataList)) { return new ArrayList(); }
//			return dataList.stream().filter(predicate).map(getData).collect(Collectors.toList());
//		}
//
//		public static <K,R> List<R> mergeList(List<R> srcList, List<R> destList ,
//											  Function<R,K> keyFunc,
//											  BinaryOperator<R> mergeFunc) {
//			return mergeList(srcList, destList, keyFunc, keyFunc, mergeFunc);
//		}
//
//		public static <T,S,K,R> List<R> mergeList(List<S> srcList, List<T> destList ,
//												  Function<S,K> skeyFunc, Function<T,K> dkeyFunc,
//												  BiFunction<S,T,R> mergeFunc) {
//
//			Map<K,S>
//				srcMap = srcList.stream().filter(x -> x != null).collect(Collectors.toMap(skeyFunc, s -> s, (k1, k2) -> k1));
//			return destList.stream().map(
//				dest -> {
//					K key = dkeyFunc.apply(dest);
//					S src = srcMap.get(key);
//					return mergeFunc.apply(src, dest);
//				}
//			).collect(Collectors.toList());
//
//		}
//
//		public static <K,T> Map<K, T> listToMap(List<T> dataList, Function<T,K> keyFunc) {
//			if (CollectionUtils.isEmpty(dataList)) {
//				return new HashMap<>();
//			}
//			return dataList.stream().collect(Collectors.toMap(keyFunc, Function.identity(), (v1,v2)->v1));
//		}
//
//		public static <T, K,S> Map<K, S> listToMap(List<T> dataList, Function<T,K> keyFunc, Function<T,S> valueFunc) {
//			if (CollectionUtils.isEmpty(dataList)) {
//				return new HashMap<>();
//			}
//			return dataList.stream().collect(Collectors.toMap(keyFunc, valueFunc, (v1,v2)->v1));
//		}
//
//		public static <K,T> Map<K,List<T>> groupingBy(List<T> dataList, Function<T,K> keyFunc) {
//			if (CollectionUtils.isEmpty(dataList)) {
//				return new HashMap<>();
//			}
//			return dataList.stream().collect(Collectors.groupingBy(keyFunc));
//		}
//
//	}

}
