package com.example.qzq.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname LRUCache
 * @Description
 * @Date 2019/11/28 14:00
 * @Created by qiziqian
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public static void main(String[] args) {


    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
