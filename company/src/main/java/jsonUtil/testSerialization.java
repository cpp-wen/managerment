package jsonUtil;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

import CommonUtil.SerializeUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/01
 **/
@Slf4j
public class testSerialization implements ObjectSerializer {

  @Override
  public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i)
	  throws IOException {
	//这边写一个测试类试用一下
	try {
	  if(Objects.isNull(o)){
		jsonSerializer.writeNull();
		return;
	  }
	  if(StringUtils.isBlank((String)o)){
		log.info("caopeng PhoneSerialize{}",o);
		//如果为空串就不进行处理
		log.info("PhoneSerialize {}");
//		jsonSerializer.write(o);
//		return;
	  }
	  String value = (String) o;
	  String around = SerializeUtil.around(value, 3, 4);
	  jsonSerializer.write(around);
	}catch (Exception e){
	  log.info("PhoneSerialize caopeng error is ",e.getMessage());
	  return;
	}
  }
}
