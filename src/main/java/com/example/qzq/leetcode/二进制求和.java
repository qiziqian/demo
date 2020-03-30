package com.example.qzq.leetcode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Classname 二进制求和
 * @Description
 * @Date 2019/10/10 12:47
 * @Created by qiziqian
 */
public class 二进制求和 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary2("11", "1"));

    }

    public static String addBinary(String a, String b) {
        String longer = a.length() > b.length() ? a : b;
        String shoter = longer.equals(a) ? b : a;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= longer.length(); i++) {
            if (i <= shoter.length()) {
                int s = Integer.parseInt(longer.charAt(longer.length() - i) + "") + Integer.parseInt(shoter.charAt(shoter.length() - i) + "");
                list.add(s);
            } else {
                int s = Integer.parseInt(longer.charAt(longer.length() - i) + "");
                list.add(s);
            }
        }
        Collections.reverse(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) >= 2) {
                list.set(i, list.get(i) - 2);
                if (i - 1 >= 0) {
                    list.set(i - 1, list.get(i - 1) + 1);
                } else {
                    list.addFirst(1);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static String addBinary2(String a, String b) {
        int ca = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            ca = sum / 2;
        }
        sb.append(ca == 1 ? 1 : "");
        return sb.reverse().toString();
    }
}
