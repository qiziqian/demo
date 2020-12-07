package com.example.qzq.leetcode;

/**
 * @ClassName : 重构字符串
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-30 13:52
 */
public class 重构字符串 {
    public static void main(String[] args) {
        //reorganizeString("vvvol");
        Boolean flag = null;
        if (Boolean.TRUE.equals(flag)) {
            System.out.println(111);
        }
    }

    public static String reorganizeString(String S) {
        if (S.length() < 2) return S;
        int[] array = new int[26];
        int length = S.length();
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            array[S.charAt(i) - 'a']++;
            maxCount = Math.max(array[S.charAt(i) - 'a'], maxCount);
            maxIndex = maxCount == array[S.charAt(i) - 'a'] ? S.charAt(i) - 'a' : maxIndex;
        }
        if (maxCount > (length + 1) / 2) return "";
        char[] result = new char[length];
        int index = 0;
        for (int i = array[maxIndex]; i > 0; i--) {
            result[index] = (char) (maxIndex + 'a');
            array[maxIndex]--;
            index += 2;
        }
        for (int i = 0; i < 26; i++) {
            while (array[i]-- > 0) {
                if (index >= result.length) index = 1;
                result[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(result);
    }
}