package com.example.qzq.剑指offer;

import com.example.qzq.data_structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : 从上到下打印二叉树
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-11 11:10
 */

public class 从上到下打印二叉树 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        levelOrder(treeNode);
    }

    public static int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        int level = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
            level++;
        }
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(list);
        return ints;
    }

    public static void recur(TreeNode root, Queue<TreeNode> queue, List<Integer> list) {


    }
}