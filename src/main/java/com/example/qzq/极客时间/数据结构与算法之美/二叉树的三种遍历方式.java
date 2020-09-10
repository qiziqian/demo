package com.example.qzq.极客时间.数据结构与算法之美;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname 二叉树的三种遍历方式
 * @Description
 * @Date 2019/11/4 9:43
 * @Created by qiziqian
 */
public class 二叉树的三种遍历方式 {
    public void preOrder(TreeNode node) {
        if (node == null) return;
        preOrder(node.left);
        System.out.println(node);
        preOrder(node.right);
    }

    public void inOrder(TreeNode node) {
        if (node == null) return;
        System.out.println(node);
        inOrder(node.left);
        inOrder(node.right);
    }

    public void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }

    public List<Integer> preOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (node == null) return list;
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
