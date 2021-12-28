package com.ctk.study.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/9/27 3:24 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
public class CClass<T> {
    private List<T> items = new ArrayList<>(10);

    public CClass() {

    }

    public T getItems(int index) {
        return items.get(index);
    }

    public void setItems(T t) {
       items.add(t);
    }
}
