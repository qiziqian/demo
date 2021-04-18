package com.example.qzq.acwing.数学知识.质数;

import java.util.Scanner;

/**
 * @Description
 * @Date 2021/4/16 21:50
 * @Author by qiziqian
 */
public class 试除法判定质数 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            System.out.println(isPrime(u) ? "Yes" : "No");
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
