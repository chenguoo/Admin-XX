package com.javamokey.adminxx.common.exception;

import java.io.Serializable;

/**
 * 说明:
 *
 * @author Cheney <br>
 * modified by :
 * @version 1.0 <br>
 * Created in 2017-12-25 17:18
 */
public class AppException extends RuntimeException implements Serializable{

    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
