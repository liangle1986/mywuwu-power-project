package com.mywuwu.exception;

/**
 * @Package: com.mywuwu.exception
 * @Description： TODO
 * @Author: 梁乐乐
 * @Date: Created in 2018/8/22 21:45
 * @Company: ywuwu.com
 * @Copyright: Copyright (c) 2018
 * @Version: 0.0.1
 * @Modified By:
 */
public class UsernameIsExitedException extends BaseException {

    public UsernameIsExitedException(String msg) {
        super(msg);
    }

    public UsernameIsExitedException(String msg, Throwable t) {
        super(msg, t);
    }
}