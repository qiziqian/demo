package com.example.qzq.concurrent;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Classname TestHashMap
 * @Description
 * @Date 2019/9/3 16:49
 * @Created by qiziqian
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap map = new HashMap<>();
        map.put("111", "11");
        ConcurrentHashMap map1 = new ConcurrentHashMap();
        map1.put("111", "111");
        Hashtable hashtable = new Hashtable();
        hashtable.put("11", "11");
    }
}
