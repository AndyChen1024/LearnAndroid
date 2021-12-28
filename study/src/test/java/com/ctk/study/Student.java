package com.ctk.study;

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/11/5 1:54 下午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
public class Student<T> {
    private String score;

    public Student() {

    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
