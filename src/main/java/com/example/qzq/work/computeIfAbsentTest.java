package com.example.qzq.work;

import java.util.HashMap;

/**
 * @ClassName : computeIfAbsentTest
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-14 17:50
 */
public class computeIfAbsentTest {
    public static void main(String[] args) throws InterruptedException {

        String s = null;
        try {
            s.equals(123);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.toString());
        }
    }
}