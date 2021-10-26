package SerializationFastJson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/04
 **/
public class AddressSerialize implements ObjectSerializer {

  @Override
  public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i)
	  throws IOException {
	jsonSerializer.write("caopeng");
  }
}
