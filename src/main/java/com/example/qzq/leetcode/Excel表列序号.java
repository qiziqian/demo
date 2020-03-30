package com.example.qzq.leetcode;

/**
 * @Classname Excel表列序号
 * @Description
 * @Date 2019/12/27 16:58
 * @Created by qiziqian
 */
public class Excel表列序号 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String s) {
        int len = s.length() - 1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += (s.charAt(i) - 'A' + 1) * Math.pow(26, len--);
        }
        return ans;
    }
}
