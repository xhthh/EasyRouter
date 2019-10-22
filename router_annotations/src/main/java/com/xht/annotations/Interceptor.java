package com.xht.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xht on 2019/10/22.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Interceptor {

    /**
     * 拦截器优先级
     */
    int priority();

    /**
     * 拦截器名称
     */
    String name() default "";

}
