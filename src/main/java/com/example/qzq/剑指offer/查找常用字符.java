package com.example.qzq.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : 查找常用字符
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-14 10:33
 */
public class 查找常用字符 {

    public static void main(String[] args) {
        commonChars2(new String[]{"bella", "label", "roller"});
    }

    public static List<String> commonChars(String[] A) {

        int[][] hashArray = new int[A.length + 1][26];

        for (int index = 0; index < A.length; index++) {
            for (char ch : A[index].toCharArray()) {
                hashArray[index][ch - 'a']++;
            }
        }
        Arrays.fill(hashArray[A.length], Integer.MAX_VALUE);
        for (int row = 0; row < hashArray.length - 1; row++) {
            for (int column = 0; column < 26; column++) {
                if (hashArray[A.length][column] == -1) continue;
                if (hashArray[row][column] > 0) {
                    hashArray[A.length][column] = Math.min(hashArray[row][column], hashArray[A.length][column]);
                } else if (hashArray[row][column] == 0) {
                    hashArray[A.length][column] = -1;
                }
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < hashArray[A.length].length; i++) {
            if (hashArray[A.length][i] == -1) continue;
            for (int j = 1; j <= hashArray[A.length][i]; j++) {
                list.add((char) (i + 'a') + "");
            }

        }

        return list;

    }

    //简化空间
    public static List<String> commonChars2(String[] A) {
        int[] hashArray = new int[26];

        Arrays.fill(hashArray, Integer.MAX_VALUE);
        for (int index = 0; index < A.length; index++) {
            int[] temp = new int[26];
            for (char ch : A[index].toCharArray()) {
                temp[ch - 'a']++;
            }
            for (int i = 0; i < hashArray.length; i++) {
                hashArray[i] = Math.min(hashArray[i], temp[i]);
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] == 0) continue;
            for (int j = 1; j <= hashArray[i]; j++) {
                list.add((char) (i + 'a') + "");
            }

        }

        return list;

    }
}