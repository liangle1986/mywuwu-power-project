package com.mywuwu.exception;

/**
 * @Package: com.mywuwu.exception
 * @Description： TODO
 * @Author: 梁乐乐
 * @Date: Created in 2018/8/22 21:44
 * @Company: ywuwu.com
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}