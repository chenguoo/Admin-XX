package com.javamokey.adminxx.common.util;

import com.javamokey.adminxx.common.exception.AppException;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * 说明:
 *
 * @author Cheney <br>
 * modified by :
 * @version 1.0 <br>
 * Created in 2017-12-25 17:15
 */
public class BeanUtils {

    /**
     * 对象属性复制
     *
     * @param source 原对象
     * @param dest   目标对象
     * @author Cheney <br>
     */
    public void copyAttribute(Object source, Object dest) {

//        org.springframework.beans.BeanUtils.copyProperties(source, dest);

        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(dest, source);
        } catch (IllegalAccessException e) {
            throw new AppException(e);
        } catch (InvocationTargetException e) {
            throw new AppException(e);
        }
    }

    /**
     * 判断集合是否为空
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {

        return collection == null || collection.isEmpty();
    }


}

