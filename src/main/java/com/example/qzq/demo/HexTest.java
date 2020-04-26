package com.example.qzq.demo;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.util.Arrays;

/**
 * @Classname HexTest
 * @Description
 * @Date 2020/4/15 14:08
 * @Created by qiziqian
 */
public class HexTest {
    public static void main(String[] args) {
        byte[] bytes = {0x02, (byte) 0x92, (byte) 0xFF, (byte) 0x9B};
        byte[] array1 = Arrays.copyOfRange(bytes, 0, 2);
        byte[] array2 = Arrays.copyOfRange(bytes, 2, 4);

        double complement1 = (double) complement(array1) / 10;
        double complement2 = (double) complement(array2) / 10;

    }


    public static int complement(byte[] bytes) {
        int i = 0;
        if (bytes[0] != -1) {
            String encode = HexBin.encode(bytes);
            i = Integer.parseInt(encode, 16);
        } else {
            i = bytes[1];
        }
        return i;
    }
}
