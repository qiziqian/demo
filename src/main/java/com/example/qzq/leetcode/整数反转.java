package com.example.qzq.leetcode;

/**
 * @Classname 整数反转
 * @Description
 * @Date 2019/10/8 13:46
 * @Created by qiziqian
 */
public class 整数反转 {
    public static void main(String[] args) {
        int reverse = reverse(123);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        String s = new StringBuilder(x + "").reverse().toString();
        if (s.contains("-")) {
            s = "-" + s.substring(0, s.length() - 2);
        }
        int i;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
        return i;
    }
}
