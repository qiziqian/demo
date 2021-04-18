package com.example.qzq.acwing.数学知识.约数;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Description
 * @Date 2021/4/18 9:51
 * @Author by qiziqian
 */
public class 试除法求约数 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            getYueShu(x);
        }

    }

    public static void getYueShu(int x) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= x / i; i++) {
            if (x % i == 0) {
                set.add(i);
                if (i != x / i) set.add(x / i);
            }
        }
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
