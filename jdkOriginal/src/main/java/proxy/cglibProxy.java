package proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author:maidang
 * @date:2021/09/20
 **/
public class cglibProxy {
  private static BookApi createCglibDynamicProxy(final BookApi delegate) throws Exception {
	Enhancer enhancer = new Enhancer();
	enhancer.setCallback(new CglibInterceptor(delegate));
	enhancer.setInterfaces(new Class[]{BookApi.class});
	BookApi cglibProxy = (BookApi) enhancer.create();
	return cglibProxy;
  }
  private static class CglibInterceptor implements MethodInterceptor {

	final Object delegate;

	CglibInterceptor(Object delegate) {
	  this.delegate = delegate;
	}

	@Override
	public Object intercept(Object object, Method method, Object[] objects,
							MethodProxy methodProxy) throws Throwable {
	  // 添加代理逻辑
	  if(method.getName().equals("sell")) {
		System.out.print("");
	  }
	  return null;
//            return methodProxy.invoke(delegate, objects);
	}
  }

}
