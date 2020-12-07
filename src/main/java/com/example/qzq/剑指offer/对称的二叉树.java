package com.example.qzq.剑指offer;

import com.example.qzq.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : 对称的二叉树
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-23 10:31
 */
public class 对称的二叉树 {
    List<List<Integer>> list = new ArrayList();

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return recur(left.left, right.left) && recur(left.right, right.right);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) recur(root, 0);
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }

    public void recur(TreeNode node, int level) {
        if (list.size() == level) list.add(new ArrayList<Integer>());
        list.get(level).add(node.val);
        recur(node.left, level + 1);
        recur(node.right, level + 1);
    }
}