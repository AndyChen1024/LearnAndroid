package com.ctk.study;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.ctk.study.myinterface.Jump;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/11/29 4:10 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
class JumpUtils {
    public static void jumpInject(Activity activity){
        Class<? extends Activity> cls = activity.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        for(Field field : declaredFields ){
            LogUtils.d(field.getName());
            Jump jump = field.getAnnotation(Jump.class);
            StringUtils.isEmpty(jump.data1());
        }
    }
}
