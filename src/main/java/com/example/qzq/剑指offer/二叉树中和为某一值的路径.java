package com.example.qzq.剑指offer;

import com.example.qzq.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : 二叉树中和为某一值的路径
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-14 12:01
 */
public class 二叉树中和为某一值的路径 {
    List<List<Integer>> pathList = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum, new ArrayList<>());
        return pathList;
    }

    public void recur(TreeNode node, int sum, List<Integer> list) {
        sum -= node.val;
        if (sum < 0) return;
        list.add(node.val);
        if (node.left == null && node.right == null && sum == 0) {
            pathList.add(list);
        }
        if (node.left != null) recur(node.left, sum, new ArrayList<>(list));
        if (node.right != null) recur(node.right, sum, new ArrayList<>(list));

    }

}