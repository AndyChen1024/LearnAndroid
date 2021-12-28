package com.ctk.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/9/27 3:00 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
public class TestJava {
    @Test
     public void test(){
        List<? extends A> aList = new ArrayList();
        A a = new A();
//        a.setT(new Object());
        B b = new B();
//        b.setX(new Object());
//        aList.add(a);
//        aList.add(b);
        A result = (A)aList.get(0);
//        print(aList);
    }

    private void print(List<? extends B> list) {
       for(int i=0;i<list.size();i++){
            list.get(i).setX(String.valueOf(i));
       }
       for(int i = 0;i< list.size();i++){
           list.get(i).getX();
       }
    }


    public static class A<T> extends Object  {

        T t;

        public A() {
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public static class B<X> extends A {
        X t;
        public B() {
        }


        public X getX() {
            return t;
        }

        public void setX(X t) {
            this.t = t;
        }
    }

}
