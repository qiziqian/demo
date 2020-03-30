package com.example.qzq.concurrent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * volatile   原子性测试
 * <p>
 * 关键点  内存屏障
 */
public class VolatileSerialTest {
    static int x, y = 0;

    public static void main(String[] args) throws InterruptedException {
        HashSet<String> resultSet = new HashSet<String>();
        final Map<String, Integer> resultMap = new HashMap<String, Integer>();
        for (int i = 0; i <= 100000; i++) {
            x = 0;
            y = 0;
            resultMap.clear();
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    int a = y;
                    x = 1;
                    resultMap.put("a", a);
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                public void run() {
                    int b = x;
                    y = 1;
                    resultMap.put("b", b);
                }
            });
            thread.start();
            thread2.start();
            thread.join();
            thread2.join();
            resultSet.add("a=" + resultMap.get("a") + " b=" + resultMap.get("b"));
            System.out.println(resultSet);
        }

    }
}
