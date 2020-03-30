package com.example.qzq.sortDemo;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Classname MyLinkedLIstTest
 * @Description
 * @Date 2019/9/12 13:43
 * @Created by qiziqian
 */
public class MyLinkedLIstTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // list.addLast();
//        list.get()
        // list.remove();
//        list.toString()
        list.add(0, 111);
        MyLinkedList linkedList = new MyLinkedList();
        //  Collections.sort(list);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory());
        // 4321   4213
        linkedList.addAtHead(1);
        linkedList.addAtHead(2);
        linkedList.addAtHead(3);
        linkedList.addAtHead(8);
        linkedList.addAtHead(16);
        linkedList.addAtHead(23);
        linkedList.addAtHead(4);
        linkedList.addAtIndex(4, 3);
        linkedList.addAtIndex(1, 3);
        linkedList.deleteAtIndex(2);
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList);
        linkedList.sort();
        System.out.println(linkedList);

    }
}
