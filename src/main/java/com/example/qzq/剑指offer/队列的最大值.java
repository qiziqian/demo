package com.example.qzq.剑指offer;

import java.util.*;

/**
 * @ClassName : 队列的最大值
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-30 15:48
 */
public class 队列的最大值 {


    Queue<Integer> queue = new LinkedList();
    Deque<Integer> maxDeque = new LinkedList();

    public int max_value() {
        return maxDeque.isEmpty() ? -1 : maxDeque.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < value) {
            maxDeque.pollLast();
        }
        maxDeque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int poll = queue.poll();

        if (poll == maxDeque.peekFirst()) {
            maxDeque.pollFirst();
        }

        return poll;
    }

    public String[] findWords(String[] words) {
        int[] array = new int[26];
        array[0] = 2;
        array[1] = 3;
        array[2] = 3;
        array[3] = 2;
        array[4] = 1;
        array[5] = 2;
        array[6] = 2;
        array[7] = 2;
        array[8] = 1;
        array[9] = 2;
        array[10] = 2;
        array[11] = 2;
        array[12] = 3;
        array[13] = 3;
        array[14] = 1;
        array[15] = 1;
        array[16] = 1;
        array[17] = 1;
        array[18] = 2;
        array[19] = 1;
        array[20] = 1;
        array[21] = 3;
        array[22] = 1;
        array[23] = 3;
        array[24] = 1;
        array[25] = 3;
        List<String> result = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            int firstIndex = array[words[i].toLowerCase().charAt(0) - 'a'];
            for (int j = 0; j < words[i].length(); j++) {
                int currIndex = array[words[i].toLowerCase().charAt(j) - 'a'];
                if (firstIndex != currIndex) break;
            }
            result.add(words[i]);
        }
        return result.toArray(new String[result.size()]);
    }
}