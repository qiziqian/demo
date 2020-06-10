package com.example.qzq.effective_java.并发;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ConcurrentHashMapTest
 * @Description
 * @Date 2020/5/6 16:06
 * @Created by qiziqian
 */
public class ConcurrentHashMapTest {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        map.put(1, 1);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                map.put(1, map.get(1) + 1);
            });
        }
        Thread.sleep(3000);
        System.out.println("main:" + map.get(1));

    }
//    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        executorService.execute(() -> {
//            map.put(1, 1);
//            System.out.println("main:" + map.get(1));
//
//        });
//        Thread.sleep(3000);
//        System.out.println( map);
//    }
}
