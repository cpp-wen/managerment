package proxy;

import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtNewConstructor;
import org.apache.ibatis.javassist.CtNewMethod;

/**
 * @description:
 * @author:maidang
 * @date:2021/09/20
 **/
public class javassist {

  private static BookApi createJavassistBytecodeDynamicProxy() throws Exception {
	ClassPool mPool = new ClassPool(true);
	CtClass mCtc = mPool.makeClass(BookApi.class.getName() + "JavaassistProxy");
	mCtc.addInterface(mPool.get(BookApi.class.getName()));
	mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
	mCtc.addMethod(CtNewMethod.make(
		"public void sell(){ System.out.print(\"\") ; }", mCtc));
	Class<?> pc = mCtc.toClass();
	BookApi bytecodeProxy = (BookApi) pc.newInstance();
	return bytecodeProxy;
  }

}
