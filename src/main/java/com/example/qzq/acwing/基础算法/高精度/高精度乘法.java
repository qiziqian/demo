package com.example.qzq.acwing.基础算法.高精度;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : 高精度乘法
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-25 16:56
 */
public class 高精度乘法 {
    /*

    高精度整数 * 低精度整数
      初始化步骤与加法一样
      后 续步骤:
       res[i] = (A[i] *B+进位)%10;
       进位 =(A[i] *B+进位)/10;

   */
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String s1 = cin.readLine().split(" ")[0];
        String s2 = cin.readLine().split(" ")[0];
        int[] a = transform(s1);
        int b = Integer.parseInt(s2);
        List<Integer> res = mul(a, b);

        //去掉前面的0
        while (res.size() > 1 && res.get(res.size() - 1) == 0) res.remove(res.size() - 1);
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i));
        }
    }


    public static List<Integer> mul(int[] a, int b) {
        int m = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            m += a[i] * b;
            res.add(m % 10);
            m = m / 10;
        }
        if (m > 0) res.add(m);
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