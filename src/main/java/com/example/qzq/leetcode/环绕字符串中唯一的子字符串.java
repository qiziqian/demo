package com.example.qzq.leetcode;

import java.util.HashSet;

/**
 * @Classname 环绕字符串中唯一的子字符串
 * @Description
 * @Date 2019/10/7 14:12
 * @Created by qiziqian
 */
public class 环绕字符串中唯一的子字符串 {
    static String s = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString2("zab"));
        System.out.println(s.indexOf("a") - s.indexOf("z"));
    }

    public static int findSubstringInWraproundString2(String p) {
        char[] chars = p.toCharArray();
        int[] count = new int[26];
        int currMaxlen = 1;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (chars[i] - chars[i - 1] == 1 || chars[i] - chars[i - 1] == -25)) {
                currMaxlen++;
            } else {
                currMaxlen = 1;
            }
            count[chars[i] - 'a'] = Math.max(count[chars[i] - 'a'], currMaxlen);
        }
        int temp = 0;
        for (int i = 0; i < count.length; i++) {
            temp += count[i];
        }
        return temp;
    }

    //超时
    public static int findSubstringInWraproundString(String p) {
        char[] chars = p.toCharArray();
        HashSet set = new HashSet();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        int count = set.size();

        for (int i = 0; i < chars.length; i++) {
            String str = chars[i] + "";
            for (int j = i + 1; j < chars.length; j++) {
                str += chars[j];
                if (set.contains(str)) {
                    continue;
                }
                if (chars[j] - chars[j - 1] == 1 || chars[j] - chars[j - 1] == -25) {
                    set.add(str);
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

}
