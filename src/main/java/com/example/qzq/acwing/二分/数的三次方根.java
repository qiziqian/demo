package com.example.qzq.acwing.二分;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Description
 * @Date 2021/2/24 22:16
 * @Author by qiziqian
 */
public class 数的三次方根 {

    /*
        浮点数二分,保留6位小数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double v = scanner.nextDouble();
        System.out.println(String.format("%.6f", binarySearch(v)));
    }

    public static double binarySearch(double x) {
        //右边界不可以小于1
        double l = -10000, r = 10000;
        while (r - l > 1e-8) {
            double mid = (l + r) / 2;
            if (mid * mid * mid > x) {
                r = mid;
            } else l = mid;
        }
        return l;
    }
}
