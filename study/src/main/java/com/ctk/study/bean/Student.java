package com.ctk.study.bean;

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/11/25 2:20 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
public class Student {
    public Student(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
