package com.example.qzq.leetcode;

import java.util.HashMap;

/**
 * @Classname 罗马数字转整数
 * @Description
 * @Date 2019/10/29 15:57
 * @Created by qiziqian
 */
public class 罗马数字转整数 {
    public static void main(String[] args) {
        romanToInt("DCXXI");
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i >= 1 && map.containsKey(s.substring(i - 1, i + 1))) {
                num += map.get(s.substring(i - 1, i + 1));
                i--;
            } else if (i >= 0 && map.containsKey(s.substring(i, i + 1))) {
                num += map.get(s.substring(i, i + 1));
            }

        }
        System.out.println(num);
        return num;
    }
}
