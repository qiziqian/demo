package com.example.qzq.leetcode;

/**
 * @Classname 快乐数
 * @Description
 * @Date 2020/1/6 13:33
 * @Created by qiziqian
 */
public class 快乐数 {

    public int sum(int num) {
        int count = 0;
        while (num > 0) {
            int temp = num % 10;
            count += temp * temp;
            num /= 10;
        }
        return count;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = sum(slow);
            fast = sum(fast);
            fast = sum(fast);
        }
        while (slow != fast);
        return slow == 1;
    }
}
