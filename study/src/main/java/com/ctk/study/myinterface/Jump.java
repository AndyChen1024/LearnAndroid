package com.ctk.study.myinterface;

import android.app.Activity;
import android.content.Context;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/11/29 12:14 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Jump {

    String data1() default "";
    String data2() default "";

}
