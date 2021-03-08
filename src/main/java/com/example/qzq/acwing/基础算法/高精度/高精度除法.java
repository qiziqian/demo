package com.example.qzq.acwing.基础算法.高精度;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : 高精度除法
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-25 17:25
 */
public class 高精度除法 {

    /*
    高精度整数 /低精度整数

    除法运算适合从首位开始,但是由于在多数问题里,经常会出现加减乘除混合运算,因此也倒序处理
     */
    static int r = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String s1 = cin.readLine().split(" ")[0];
        String s2 = cin.readLine().split(" ")[0];
        int[] a = transform(s1);
        int b = Integer.parseInt(s2);
        List<Integer> res = div(a, b);

        //去掉前面的0
        while (res.size() > 1 && res.get(res.size() - 1) == 0) res.remove(res.size() - 1);
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i));
        }
        System.out.println(r);
    }


    public static List<Integer> div(int[] a, int b) {
        int m = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            m = m * 10 + a[i];
            res.add(m / b);
            m %= b;
        }
        Collections.reverse(res);
        r = m;
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