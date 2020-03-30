package com.example.qzq.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 对称二叉树
 * @Description
 * @Date 2019/12/24 13:47
 * @Created by qiziqian
 */
public class 对称二叉树 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            q.add(node1.left);
            q.add(node2.right);
            q.add(node1.right);
            q.add(node2.left);
        }
        return true;
    }

}
