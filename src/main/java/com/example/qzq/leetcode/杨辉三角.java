package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 杨辉三角
 * @Description
 * @Date 2019/12/25 9:49
 * @Created by qiziqian
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> lastRow = list.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(lastRow.get(j) + lastRow.get(j - 1));
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }
}
