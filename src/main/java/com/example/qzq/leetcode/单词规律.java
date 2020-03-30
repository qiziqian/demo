package com.example.qzq.leetcode;

import java.util.HashMap;

/**
 * @Classname 单词规律
 * @Description
 * @Date 2019/10/9 21:22
 * @Created by qiziqian
 */
public class 单词规律 {
    public static void main(String[] args) {
        wordPattern("abba", "dog cat cat fff");
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        char[] chars = pattern.toCharArray();
        if (chars.length != split.length) return false;
        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> map2 = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                if (map.containsValue(split[i])) return false;
                map.put(chars[i], split[i]);

            }
            if (!map2.containsKey(split[i])) {
                map2.put(split[i], chars[i]);
            }
            if (!map.get(chars[i]).equals(split[i])) return false;
            if (!map2.get(split[i]).equals(chars[i])) return false;
        }
        return true;
    }
}
