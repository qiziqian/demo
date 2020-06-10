package com.example.qzq.data_structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname 数组和链表
 * @Description
 * @Date 2020/6/9 13:35
 * @Created by qiziqian
 */
public class 数组和链表遍历速度 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> chain = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
            chain.add(i);
        }
        long l1 = forTest(list);
        long l2 = forTest(chain);
        long l3 = iteratorTest(list);
        long l4 = iteratorTest(chain);
        System.out.println("for循环 数组遍历花费时间:" + l1);
        System.out.println("for循环 链表遍历花费时间:" + l2);

        System.out.println("迭代器循环 数组遍历花费时间:" + l3);
        System.out.println("迭代器循环 链表遍历花费时间:" + l4);


    }

    public static long iteratorTest(List<Integer> list) {

        long l1 = System.currentTimeMillis();
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            System.out.println(next);
        }
        long l2 = System.currentTimeMillis();

        return l2 - l1;
    }

    public static long forTest(List<Integer> list) {
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Integer integer = list.get(i);
            System.out.println(integer);
        }
        long l2 = System.currentTimeMillis();
        return l2 - l1;
    }
}
