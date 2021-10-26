import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import CommonUtil.StringUtil;
import annotation.withMember;
import lombok.Data;

/**
 * @description:
 * @author:maidang
 * @date:2021/09/27
 **/
@Data
public class User {
  @test
  private String id;

  @test
  @withMember(name = StringUtil.name1)
  private String name;

  @test
  private String age;


  public User() {
  }

  public User(String id, String name, String age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }



  public static void main(String[] args)
      throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
    long x = System.currentTimeMillis();
    System.out.println(x);
    for (int i = 0; i < 1; i++) {
      //增加这块参数构建
      User user  =new User("1","1","1");
      Object object=(Object)user;
      Class clz = user.getClass();
      Field[] declaredFields = clz.getDeclaredFields();
      for (Field field:declaredFields){
        boolean annotationPresent = field.isAnnotationPresent(test.class);
        if(annotationPresent){
          object=handeler(user,field);
        }else{
          //dont
        }
      }
    }
    System.out.println(System.currentTimeMillis()-x);
  }

  public static  Object handeler(Object object,Field filed)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
      Class clz = object.getClass();
      String name =firstUpperCase(filed.getName());
      filed.setAccessible(true);
      Method getmethod= clz.getMethod("get"+name);
      Object value= getmethod.invoke(object);
      if(value instanceof String){
      //进入string 处理流程
        Method setMethod = clz.getMethod("set"+name,filed.getType());
        //模糊化处理
        setMethod.invoke(object,"测试方法");
        return object;
      }
      else {
        return "else";
      }
  }


  public static String firstUpperCase(String value){
    char[] cs=value.toCharArray();
    cs[0]-=32;
    return String.valueOf(cs);
  }
}
