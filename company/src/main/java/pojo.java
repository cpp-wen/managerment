import java.io.Serializable;

import lombok.Data;

/**
 * @description:
 * @author:maidang
 * @date:2021/09/25
 **/
@Data
public class pojo implements Serializable {

  private static final long serialVersionUID = -6946792796641401778L;

  Integer age;
  String name;
  Long age2;
}
