package com.javamokey.adminxx.common.util;

import com.alibaba.fastjson.JSON;
import com.javamokey.adminxx.common.exception.AppException;

/**
 * 说明:数据检查工具类
 *
 * @author Cheney <br>
 * modified by :
 * @version 1.0 <br>
 * Created in 2017-12-25 17:05
 */
public class CheckUtil {

    public static void check(boolean condition, String msgKey, Object... args) {
        if (!condition) {
            fail(msgKey, args);
        }
    }

    public static void notEmpty(String str, String msgKey, Object... args) {
        if (str == null || str.isEmpty()) {
            fail(msgKey, args);
        }
    }

    public static void notNull(Object obj, String msgKey, Object... args) {
        if (obj == null) {
            fail(msgKey, args);
        }
    }

    private static void fail(String msgKey, Object... args) {
        String argsString = JSON.toJSONString(args);
        throw new AppException(msgKey + "参数:" + argsString);
    }
}
