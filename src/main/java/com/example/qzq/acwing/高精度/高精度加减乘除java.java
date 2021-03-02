package com.example.qzq.acwing.高精度;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @ClassName : 高精度加减乘除java
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-25 10:27
 */
public class 高精度加减乘除java {

    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String s1 = cin.readLine().split(" ")[0];
        String s2 = cin.readLine().split(" ")[0];
        BigInteger n = new BigInteger(s1);
        BigInteger m = new BigInteger(s2);
        //加
        n.add(m);
        //减
        n.subtract(m);
        //乘
        n.multiply(m);
        //除
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));

    }

}