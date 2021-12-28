package com.ctk.study;


import com.ctk.study.bean.BaseStudent;
import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *     @author : taikang_chen
 *     @time   : 2021/11/5 11:41 上午
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
public class TestMain {
    @Test
    public void main(){
        List<?> list = new ArrayList<Integer>();
        list = new ArrayList<>();

//        test(list);
//        test2();
        test3();
    }

    private void test3() {
        Map<String,Object> map = new HashMap<>();
        System.out.println(map.get("test"));
    }

    private void test2() {
        Gson gson =new Gson();
        List<com.ctk.study.bean.Student> list1 = new ArrayList<>();
        list1.add(new com.ctk.study.bean.Student("1",1));
        List<com.ctk.study.bean.Student> list2 = new ArrayList<>();
        list2.add(new com.ctk.study.bean.Student("2",2));
        list1.addAll(list2);
        System.out.println(gson.toJson(list1));
        List<BaseStudent> list3 = new ArrayList<>();
        list3.add(new com.ctk.study.bean.BaseStudent("3",3));
        list1.addAll(list3);
        System.out.println(gson.toJson(list1));

        List<? extends String> listA;
        List<? super String> listB;

    }

    private static void test(List<?> list) {
        Student<String> student = new Student<String>();
        student.setScore("great");

        MyClass<Student<String>> cls = new MyClass<>();
        cls.setCls(student);
        Student<String> stu2 = new Student<>();
        stu2.setScore(cls.getCls().getScore());
        System.out.println(stu2.getScore());

        Map<String,String> map = new HashMap<>();
        map.put("a","java");
        map.put("b","python");
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for (Map.Entry<String,String> entry:entrySet){
            String key = entry.getKey();
            String value = entry.getValue();
        }
        System.out.println();

    }
}
