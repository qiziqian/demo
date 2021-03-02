package com.example.qzq.acwing.高精度;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : 大整数相加
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-25 09:56
 */
public class 高精度加法 {


    /*
     例如 "123456789" + "123456789"
    1.借用数组倒叙存储 ,然后相加,满十进一即可
    2.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String s1 = cin.readLine().split(" ")[0];
        String s2 = cin.readLine().split(" ")[0];
        int[] a = transform(s1);
        int[] b = transform(s2);
        List<Integer> res = add(a, b);
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i));
        }
    }

    public static List<Integer> add(int[] a, int[] b) {
        int add = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.max(a.length, b.length); i++) {
            if (i < a.length) add += a[i];
            if (i < b.length) add += b[i];
            res.add(add % 10);
            add /= 10;
        }
        if (add == 1) res.add(1);
        return res;
    }

    public static int[] transform(String a) {
        int n = a.length() - 1;
        int[] nums = new int[a.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a.charAt(n - i) - '0';
        }
        return nums;
    }
}