package com.ctk.study;

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/11/5 1:53 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
public class MyClass<T> {
    private  T cls;
    public MyClass() {
    }

    public T getCls() {
        return cls;
    }

    public void setCls(T cls) {
        this.cls = cls;
    }
}
