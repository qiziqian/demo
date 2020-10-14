package com.example.qzq.剑指offer;

import java.util.ArrayList;

/**
 * @ClassName : 圆圈中最后剩下的数字
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-28 16:49
 */
public class 圆圈中最后剩下的数字 {

    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}