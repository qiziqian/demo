package com.example.qzq.剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : 最长不含重复字符的子字符串
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-28 10:47
 */
public class 最长不含重复字符的子字符串 {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] array = new int[128];
        int maxLength = 0;
        for (int leftIndex = 0, i = 0; i < s.length(); i++) {
            leftIndex = Math.max(array[s.charAt(i)], leftIndex);
            array[s.charAt(i)] = i + 1;
            maxLength = Math.max(maxLength, i - leftIndex + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int result = 0;
        int currLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = dic.getOrDefault(s.charAt(i), -1);
            dic.put(s.charAt(i), i);
            currLength = currLength >= i - index ? i - index : currLength + 1;
            result = Math.max(currLength, result);
        }
        return result;
    }


}