package com.example.qzq.acwing.数学知识.质数;

import java.util.Scanner;

/**
 * @Description
 * @Date 2021/4/17 10:08
 * @Author by qiziqian
 */
public class 分解质因数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            divide(x);
        }
    }

    public static void divide(int x) {
        for (int i = 2; i <= x / i; i++) {
            int c = 0;
            while (x % i == 0) {
                c++;
                x /= i;
            }
            if (c > 0) System.out.println(i + " " + c);
        }

        if (x > 1) System.out.println(x + " " + 1);
        System.out.println();
    }

}
