package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Classname 加一
 * @Description
 * @Date 2019/10/9 17:52
 * @Created by qiziqian
 */
public class 加一 {
    public static void main(String[] args) {
        System.out.println(plusOne(new int[]{9, 9, 7, 6, 5, 4, 3, 2, 1, 0}));
    }

    public static int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean add = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && add) {
                list.add(0);
                add = true;
            } else if (add) {
                add = false;
                list.add(digits[i] + 1);
            } else {
                list.add(digits[i]);
            }
        }
        if (list.get(list.size() - 1) == 0) {
            list.add(1);
        }
        Collections.reverse(list);
        int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();
        return ints;
    }
}
