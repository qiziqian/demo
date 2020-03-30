package com.example.qzq.leetcode;

/**
 * @Classname 整数转罗马数字
 * @Description
 * @Date 2019/10/29 16:37
 * @Created by qiziqian
 */
public class 整数转罗马数字 {
    public static void main(String[] args) {
        intToRoman2(3);
    }

    public static String intToRoman(int num) {
        int qian = num / 1000;
        int bai = num % 1000 / 100;
        int shi = num % 100 / 10;
        int ge = num % 10;
        StringBuilder builder = new StringBuilder();
        builder = collect(builder, qian, "", "M", "");
        builder = collect(builder, bai, "D", "C", "M");
        builder = collect(builder, shi, "L", "X", "C");
        builder = collect(builder, ge, "V", "I", "X");
        System.out.println(builder.toString());
        return builder.toString();
    }

    public static StringBuilder collect(StringBuilder builder, int num, String s1, String s2, String s3) {
        if (num == 9) {
            builder.append(s2 + s3);
            return builder;
        }
        if (num == 4) {
            builder.append(s2 + s1);
            return builder;
        }
        if (num >= 5) {
            builder.append(s1);
            num -= 5;
        }
        while (num > 0 && num < 4) {
            builder.append(s2);
            num--;
        }
        return builder;
    }

    public static String intToRoman2(int num) {
        int[] intArray = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strArray = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            int curr = num / intArray[i];
            while (curr > 0) {
                builder.append(strArray[i]);
                num -= intArray[i];
                curr--;
            }

            if (num <= 0) break;
        }
        return builder.toString();
    }
}
