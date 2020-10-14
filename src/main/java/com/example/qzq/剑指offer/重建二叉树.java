package com.example.qzq.剑指offer;

import com.example.qzq.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : 重建二叉树
 * @Author : qiziqian
 * @Description: 没做出来
 * @Date: 2020-08-18 15:46
 */
public class 重建二叉树 {

    Map<Integer, Integer> indexMap = new HashMap();
    int[] po;

    // 2020.09.30  参考别人的答案
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return recur(0, 0, preorder.length - 1);
    }

    public TreeNode recur(int currRoot, int left, int right) {
        if (left > right) return null;

        int rootIndex = indexMap.get(po[currRoot]);

        TreeNode root = new TreeNode(po[currRoot]);

        root.left = recur(currRoot + 1, left, rootIndex - 1);
        root.right = recur((currRoot + 1) + (rootIndex - left), rootIndex + 1, right);  //根节点索引+1+左子树长度

        return root;
    }

}