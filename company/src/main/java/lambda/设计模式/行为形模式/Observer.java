package lambda.设计模式.行为形模式;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 观察者模式 将自身注册到观察者身上
 * @author:maidang
 * @date:2022/01/03
 **/
public class Observer {
	public void main() {
		observer observer = new observer();
		observer.register("listener1", new Listener() {
			@Override
			public void onEvent() {
				System.out.println("just log listener1");
			}
		});
		observer.register("listener2",new listener2());
		observer.onEvent();
	}

	public void main2(){
		observer observer = new observer();
		//根据接口类型 可以直接转换为函数接口 或者重新定义入参类型
		observer.register("key1",()-> System.out.println("yes"));
		observer.registerFunction("key2",()-> System.out.println("yes"));
	}

	public class listener2 implements Listener{
		@Override
		public void onEvent() {
			System.out.println("just log listener2");
		}
	}
	public class observer{
		ConcurrentHashMap<Object,Listener> listenerHashMap = new ConcurrentHashMap();
		ConcurrentHashMap<Object,Runnable> functionHashMap = new ConcurrentHashMap<>();
		public void register(Object object,Listener listener){
			listenerHashMap.put(object,listener);
		}
		public void registerFunction(Object object,Runnable runnable){
			functionHashMap.put(object,runnable);
		}

		public void unregister(Object object){
			listenerHashMap.remove(object);
		}
		public void onEvent(){
			for (Listener value : listenerHashMap.values()) {
				value.onEvent();
			}
		}
		public void functionOnEvent(){
			for (Runnable value : functionHashMap.values()) {
				value.run();
			}
		}
	}

	//具体listener 要通知什么东西是由接口实现者来决定的
	interface Listener{
		public void onEvent();
	}

}
