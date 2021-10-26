package POJO;

import lombok.Data;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/15
 **/
@Data
public class ChildPOJO extends FatherPOJO{
 public String userName;
 public OtherFakePOJO otherPOJO;
}
