package com.example.qzq.socket;

import java.util.HashMap;

/**
 * @ClassName : ExceptionTest
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-15 17:10
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            HashMap<String, String> map = new HashMap();
            System.out.println(map.get("1").toString());
        } catch (Exception ex) {

            System.out.println("打印异常");
            System.out.println(ex.toString());
            System.out.println(ex.getMessage());
            System.out.println(ex.getLocalizedMessage());
        }
    }
}