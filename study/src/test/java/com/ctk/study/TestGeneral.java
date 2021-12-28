package com.ctk.study;

import androidx.annotation.NonNull;

import org.junit.Test;

import java.util.Iterator;

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/11/22 8:21 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
public class TestGeneral {

    private String testData;

    @Test
    public void test() {
        GeneralType<A> a = new GeneralType<>();
        print(a);
        GeneralType<B> b = new GeneralType<>();
//        print(b);
        print2(a);
        print2(b);

        print3(a);
        print3(b);

        GeneralType<A> aa = new GeneralType<>();
        aa.setT(new A());
        aa.getT();

    }

    private void print(GeneralType<A> a) {
        System.out.println(a.getT().toString());
    }

    /**
     * PECS原则 producer extends consumer super
     * @param a
     */
    private void print2(GeneralType<? extends A> a) {
        System.out.println(a.getT().toString());
        //生产者 使用 extends
        A aaa = a.getT();
//        a.setT(new A());
    }

    private void print3(GeneralType<? super B> b) {
        System.out.println(b.getT().toString());

        //消费者 使用 super
//        b.setT(new A());
//        B bbb = b.getT();
    }

    public class GeneralType<T> {
        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public static class A {
        public A() {
        }
    }

    public static class B extends A {
        public B() {
        }
    }
}
