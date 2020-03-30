package com.example.qzq.jvm.gc;

import java.util.HashMap;

/**
 * @Description
 * @Date 2020/2/23 10:50
 * @Author by qiziqian
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("abc", "def");
        map.put("hig", "def");
        System.out.println(map);
    }
}
