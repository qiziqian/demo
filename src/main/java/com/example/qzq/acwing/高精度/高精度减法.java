package com.example.qzq.acwing.高精度;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : 高精度减法
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-25 10:54
 */
public class 高精度减法 {

    /*
        初始化步骤与加法一样
        后 续步骤:

            if  A>= B    return A-B
            if  A<B      return -(B-A)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String s1 = cin.readLine().split(" ")[0];
        String s2 = cin.readLine().split(" ")[0];
        int[] a = transform(s1);
        int[] b = transform(s2);
        List<Integer> res;
        if (cmp(a, b)) {
            res = subtract(a, b);
        } else {
            res = subtract(b, a);
            System.out.println("-");
        }
        //去掉前面的0
        while (res.size() > 1 && res.get(res.size() - 1) == 0) res.remove(res.size() - 1);
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i));
        }
    }

    private static boolean cmp(int[] a, int[] b) {
        if (a.length != b.length) return a.length > b.length;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != b[i]) return a[i] > b[i];
        }
        return true;
    }

    public static List<Integer> subtract(int[] a, int[] b) {
        int sub = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.max(a.length, b.length); i++) {
            sub = a[i] - sub;
            if (i < b.length) sub -= b[i];
            res.add((sub + 10) % 10);
            sub = sub < 0 ? 1 : 0;
        }
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