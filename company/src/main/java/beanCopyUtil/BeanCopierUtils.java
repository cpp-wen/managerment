package beanCopyUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于cglib实现的对象复制
 *
 * @author wangxiaohu
 * @version v0.1 2018/7/23 下午10:00 $
 */
public class BeanCopierUtils {

    private static final Logger logger = LoggerFactory.getLogger(BeanCopierUtils.class);

    /**
     * 缓存转换过的bean
     */
    private final static Map<String, BeanCopier> beanCopierMap = new HashMap<>();

    /**
     * bean属性转换
     *
     * @param source
     * @param target
     */
    public static <T> T copyProperties(Object source, T target) {
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
        return target;
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

    /**
     * 将非空属性赋值给另一个对象
     */
    public static <T> void copyBeanWithNotNullProperty(T origin, T destination) {
        if (origin == null || destination == null) {
            return;
        }
        if (!origin.getClass().equals(destination.getClass())) {
            return;
        }

        List<Field> fieldList = new ArrayList<>();

        Field[] fields = origin.getClass().getDeclaredFields();
        fieldList.addAll(Arrays.asList(fields));
        Field[] baseFields = origin.getClass().getSuperclass().getDeclaredFields();
        fieldList.addAll(Arrays.asList(baseFields));

        for (Field field : fieldList) {
            try {
                field.setAccessible(true);
                Object value = field.get(origin);
                if (null != value) {
                    field.set(destination, value);
                }
                field.setAccessible(false);
            } catch (Exception e) {
                logger.error("copy failed!", e);
            }
        }
    }
}
