package com.example.qzq.acwing.数学知识.约数;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName : 约数之和
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-19 11:26
 */
public class 约数之和 {

    static Map<Integer, Integer> primes = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            getYueShuCount(x);
        }

        long mod = (long) (1e9 + 7);
        long res = 1;
        for (Integer i : primes.keySet()) {
            Integer c = primes.get(i);
            long sum = 1;
            while (c-- > 0) {
                sum = i * sum + 1;
                sum %= mod;
            }
            res *= sum;
            res %= mod;
        }

        System.out.println(res);
    }


    public static void getYueShuCount(int x) {
        for (int i = 2; i <= x / i; i++) {
            while (x % i == 0) {
                primes.put(i, primes.getOrDefault(i, 0) + 1);
                x /= i;
            }

        }
        if (x > 1) primes.put(x, primes.getOrDefault(x, 0) + 1);
    }

}