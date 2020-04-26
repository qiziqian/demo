package com.example.qzq.effective_java.泛型;

import java.util.*;

/**
 * @Classname 数组与列表
 * @Description
 * @Date 2020/4/21 11:43
 * @Created by qiziqian
 */
public class 数组与列表 {
    public static void main(String[] args) {
        //运行时抛异常  因为数组是协变的,有父子类关系,可以互相转型
        Object[] org = new Integer[2];
        org[0] = 1;
        org[1] = "abc";
        //无法编译,因为列表是可变的,不具备父子类关系,无法转型,更安全
//        List<Object> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add("123");
        Stack stack = new Stack();
    }
}
