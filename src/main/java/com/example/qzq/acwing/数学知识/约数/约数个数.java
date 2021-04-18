package com.example.qzq.acwing.数学知识.约数;

import java.util.Scanner;

/**
 * @Description
 * @Date 2021/4/18 10:07
 * @Author by qiziqian
 */
public class 约数个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int MOD = (int) (1e9 + 7);
        int res = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (curr == 0) curr += x;
            else curr *= x;

        }
        res = getYueShuCount(curr);
        res %= MOD;
        System.out.println(res);
    }

    private static int getYueShuCount(int x) {

        int res = 0;
        for (int i = 1; i <= x / i; i++) {
            if (x % i == 0) {
                res++;
                if (i != x / i) res++;
            }
        }
        return res;
    }
}
