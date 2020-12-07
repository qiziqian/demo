package com.example.qzq.剑指offer;

/**
 * @ClassName : 数字序列中某一位的数字
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-27 14:44
 */
public class 数字序列中某一位的数字 {

    public static void main(String[] args) {
        System.out.println(findNthDigit(3));
    }

    public static int findNthDigit(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            stringBuilder.append(i);
            if (stringBuilder.length() > n) break;
        }
        String s = stringBuilder.toString();
        return Integer.parseInt(s.charAt(n) + "");
    }
}