package com.ctk.study.bean;

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/11/25 2:21 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
public class BaseStudent extends Student{


    private Boolean isBase;

    public BaseStudent(String name, Integer code) {
        super(name, code);
    }

    public Boolean getBase() {
        return isBase;
    }

    public void setBase(Boolean base) {
        isBase = base;
    }
}
