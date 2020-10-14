package com.example.qzq.剑指offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName : 字符串的排列
 * @Author : qiziqian
 * @Description: 类似的题  八皇后,正方体顶点...  剑指offer第一版157页
 * @Date: 2020-09-22 10:06
 */
public class 字符串的排列 {
    static char[] chars = new char[]{0};
    static ArrayList<String> strlist = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(permutation("abcc"));
    }


    public static String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return strlist.toArray(new String[strlist.size()]);
    }

    public static void dfs(int currIndex) {
        //终结条件
        if (currIndex == chars.length) {
            strlist.add(String.valueOf(chars));
            return;
        }
        //递归内容  固定第i位
        Set<Character> set = new HashSet<>();
        for (int i = currIndex; i < chars.length; i++) {
            if (set.contains(i)) continue;
            set.add(chars[i]);
            swap(i, currIndex);
            dfs(currIndex + 1);
            swap(i, currIndex);
        }

    }

    static void swap(int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}