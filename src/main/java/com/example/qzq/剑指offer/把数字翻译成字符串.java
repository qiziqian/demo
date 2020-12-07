package com.example.qzq.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : 把数字翻译成字符串
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-27 17:12
 */
public class 把数字翻译成字符串 {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

    public static int translateNum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list);
        recur(list, 0);
        return count;
    }

    public static void recur(List<Integer> list, int index) {
        if (index >= list.size()) {
            count++;
            return;
        }

        recur(list, index + 1);
        if (index < list.size() - 1) {
            if (list.get(index) != 0 && list.get(index) * 10 + list.get(index + 1) <= 25) {
                recur(list, index + 2);
            }
        }
    }
}