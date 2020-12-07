package com.example.qzq.leetcode;

/**
 * @ClassName : 长按键入
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-21 17:54
 */
public class 长按键入 {

    public static void main(String[] args) {
        isLongPressedName("alex", "aaleex");
    }

    public static boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) return false;
        if (name.equals(typed)) return true;
        int index1 = 0, index2 = 0;
        boolean[][] dp = new boolean[typed.length() + 1][name.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < typed.length(); i++) {
            for (int j = 0; j < name.length(); j++) {
                char c1 = typed.charAt(i);
                char c2 = name.charAt(j);
                if (c1 == c2) {
                    if (i >= 1 && typed.charAt(i) == typed.charAt(i - 1)) {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i][j];
                    }

                }
            }
        }
        return dp[typed.length()][name.length()];
    }

}