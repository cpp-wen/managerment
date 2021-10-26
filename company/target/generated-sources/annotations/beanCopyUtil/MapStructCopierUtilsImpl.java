package beanCopyUtil;

import POJO.JsonFrom;
import POJO.JsonTo;
import POJO.User;
import POJO.UserTo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-10T15:38:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
public class MapStructCopierUtilsImpl implements MapStructCopierUtils {

    @Override
    public JsonTo fromtoJsonTo(JsonFrom json) {
        if ( json == null ) {
            return null;
        }

        JsonTo jsonTo = new JsonTo();

        return jsonTo;
    }

    @Override
    public User fromToUserTo(UserTo user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        return user1;
    }
}
