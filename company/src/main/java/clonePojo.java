import java.io.Serializable;

import lombok.Data;

/**
 * @description:
 * @author:maidang
 * @date:2021/09/25
 **/
@Data
public class clonePojo implements Serializable {

  private static final long serialVersionUID = -5035164244000789488L;


  Integer age;
  String name;
  Long age2;
}
