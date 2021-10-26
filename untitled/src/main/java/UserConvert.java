import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/10
 **/
@Mapper
public interface UserConvert {

  UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

  UserBO convert(UserDO userDO);

  @Mappings({
	  @Mapping(source = "id", target = "userId")
  })
  UserDetailBO convertDetail(UserDO userDO);

}
