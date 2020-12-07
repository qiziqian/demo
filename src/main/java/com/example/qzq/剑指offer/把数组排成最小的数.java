package com.example.qzq.剑指offer;

import java.util.Arrays;

/**
 * @ClassName : 把数组排成最小的数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-27 16:14
 */
public class 把数组排成最小的数 {

    public static void main(String[] args) {

        String[] str = new String[]{"3", "30", "321", "221", "345"};
        System.out.println(str[1].compareTo(str[2]));
        Arrays.sort(str, (x, y) -> (x + y).compareTo(y + x));
        //Arrays.sort(str,(x,y) -> (x + y).compareTo(y + x));
        for (int i = 0; i < str.length; i++) {
            //System.out.println(str[i]);
        }
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }
}