package beanCopyUtil;

/**
 * 对象转换工具
 */
public class BeanUtils {

//    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);
//    /**
//     * Orika
//     */
//    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//    private static MapperFacade mapper = mapperFactory.getMapperFacade();
//
//    public static boolean useCglib = false;
//
//    /**
//     * 将非空属性赋值给另一个对象
//     */
//    public static <T> void copyBeanWithNotNullProperty(T origin, T destination) {
//        BeanCopierUtils.copyBeanWithNotNullProperty(origin, destination);
//    }
//    /**
//
//     * Map objects using the MapperFacade
//     */
//    public static <T> T mapObjects(Object source, Class<T> clazz) {
//        if (source == null) {
//            return null;
//        }
//
//        if (useCglib) {
//            // 平滑迁移到cglib的对象复制
//            T destinationObject = null;
//            try {
//                destinationObject = clazz.newInstance();
//            } catch (Exception e) {
//                logger.error("requestId:{} BeanUtils 实例化对象失败！");
//            }
//            if (destinationObject != null) {
//                return BeanCopierUtils.copyProperties(source, destinationObject);
//            }
//        }
//
//        T resultObject = mapper.map(source, clazz);
//        return resultObject;
//    }
}
