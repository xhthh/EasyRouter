package com.xht.api.exception;

/**
 * Created by xht on 2019/10/23.
 */
public class NoRouteFoundException extends RuntimeException {
    public NoRouteFoundException(String detailMessage) {
        super(detailMessage);
    }
}
