package com.example.qzq.剑指offer;

import com.example.qzq.leetcode.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName : 从尾到头打印链表
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-18 15:28
 */
public class 从尾到头打印链表 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Stack<Integer> stack = new Stack<>();
        for (Integer integer : list) {
            stack.push(integer);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }


}