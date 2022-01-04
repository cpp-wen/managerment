package lambda.dailyLambda;

import com.google.common.base.Preconditions;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @description: 记录一些项目中看到的函数式编程方法 supplier
 * @author:maidang
 * @date:2021/12/29
 **/
public class supplierDaily {

	//Map创建工具类 MapBuild
	public static class MapBuilder<K,V>{
		/**
		 * 内置map
		 */
		protected Map<K, V> map;

		/**
		 * 是否允许空值
		 */
		protected boolean nullValueAllowed = true;

		public static <A, B> MapBuilder<A, B> init(Class<A> keyClass,
												   Class<B> valueClass,
												   boolean nullValueAllowed) {
			MapBuilder<A, B> mapBuilder = new MapBuilder<>();
			mapBuilder.map = new HashMap<>();
			mapBuilder.nullValueAllowed = nullValueAllowed;
			return mapBuilder;
		}

		public static MapBuilder<String, Object> init() {
			return init(String.class, Object.class, true);
		}

		public static MapBuilder<String, Object> init(boolean nullValueAllowed) {
			return init(String.class, Object.class, nullValueAllowed);
		}

		public MapBuilder<K, V> add(K key, V value) {
			Preconditions.checkArgument(key != null, "key is null");
			if (key instanceof String) {
				Preconditions.checkArgument(StringUtils.isNotBlank(key.toString()), "key is blank");
			}
			if (!this.nullValueAllowed) {
				Preconditions.checkArgument(value != null, "value is null");
			}
			this.map.put(key, value);
			return this;
		}

		public MapBuilder<K, V> add(Supplier<K> keySupplier,
									Supplier<V> valueSupplier) {
			K key = keySupplier.get();
			Preconditions.checkArgument(key != null, "key is null");
			if (key instanceof String) {
				Preconditions.checkArgument(StringUtils.isNotBlank(key.toString()), "key is blank");
			}
			V value = valueSupplier.get();
			if (!this.nullValueAllowed && value == null) {
				return this;
			}
			this.map.put(key, value);
			return this;
		}

		public Map<K, V> build() {
			return new HashMap<>(this.map);
		}

		public Map<K, V> buildUnmodifiable() {
			return Collections.unmodifiableMap(this.map);
		}
	}
	//log延迟打印日志  打印日志格式化
//	static void debug(Logger logger, String format, Supplier<?>... params) {
//		if (logger.isDebugEnabled()) {
//			logger.debug(format, LambdaUtils.getAll(params));
//		}
//	}
//	public static Object[] getAll(final Supplier<?>... suppliers) {
//		if (suppliers == null) {
//			return null;
//		}
//
//		final Object[] result = new Object[suppliers.length];
//		for (int i = 0; i < result.length; i++) {
//			result[i] = suppliers[i].get();
//		}
//		return result;
//	}

}
