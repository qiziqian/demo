package com.example.qzq.leetcode;

import java.util.*;

/**
 * @ClassName : 数据流中的中位数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-26 17:46
 */
public class 数据流中的中位数 {


    Queue<Integer> minDeap = new PriorityQueue<>();
    Queue<Integer> maxDeap = new PriorityQueue<>((x, y) -> (y - x));

    /**
     * initialize your data structure here.
     */


    public void addNum(int num) {
        if (maxDeap.size() == minDeap.size()) {
            maxDeap.add(num);
            minDeap.add(maxDeap.poll());

        } else {
            minDeap.add(num);
            maxDeap.add(minDeap.poll());
        }
    }

    public double findMedian() {
        return maxDeap.size() == minDeap.size() ? (minDeap.peek() + maxDeap.peek()) / 2.0 : maxDeap.peek();
    }

}