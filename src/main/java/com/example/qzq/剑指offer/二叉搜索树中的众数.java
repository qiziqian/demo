package com.example.qzq.剑指offer;

import com.example.qzq.data_structure.TreeNode;

import java.util.*;

/**
 * @ClassName : 二叉搜索树中的众数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-24 16:05
 */
public class 二叉搜索树中的众数 {
    Map<Integer, Integer> map = new HashMap();

    public int[] findMode(TreeNode root) {
        recur(root);
        Collection<Integer> values = map.values();
        int max = Integer.MIN_VALUE;
        for (Integer value : values) {
            max = Math.max(value, max);
        }
        List<Integer> list = new ArrayList<>();
        for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() == max) list.add(next.getKey());
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void recur(TreeNode root) {
        if (root == null) return;
        map.put(root.val, map.get(root.val) == null ? 1 : map.get(root.val) + 1);
        findMode(root.left);
        findMode(root.right);
    }
}