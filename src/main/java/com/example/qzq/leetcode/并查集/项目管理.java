package com.example.qzq.leetcode.并查集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : 项目管理
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-12 11:21
 */
public class 项目管理 {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        //组间关系图
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < m + n; i++) {
            groupGraph.add(new ArrayList<>());
        }
        //组内关系图
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        //组的Id集合
        List<Integer> gruopIds = new ArrayList<>();
        for (int i = 0; i < n + m; ++i) {
            gruopIds.add(i);
        }
        //重新分组
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < m + n; i++) {
            groups.add(new ArrayList<>());
        }
        int newGroupId = m;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = newGroupId;
                newGroupId += 1;
            }
            groups.get(group[i]).add(i);
        }
        //建图,建立入度关系
        int[] groupInDegree = new int[m + n];
        int[] itemInDegree = new int[n];
        for (int i = 0; i < group.length; i++) {
            int currGroupId = group[i];
            for (int beforeItem : beforeItems.get(i)) {
                int beforeGroupId = group[beforeItem];
                if (currGroupId == beforeGroupId) {
                    itemInDegree[i]++;
                    itemGraph.get(beforeItem).add(i);
                } else {
                    groupInDegree[currGroupId]++;
                    groupGraph.get(beforeGroupId).add(currGroupId);
                }
            }

        }
        List<Integer> groupTopSort = topSort(groupInDegree, gruopIds, groupGraph);
        if (groupTopSort.size() == 0) return new int[0];

        int[] ans = new int[n];
        int index = 0;
        // 组内拓扑关系排序
        for (int curGroupId : groupTopSort) {
            int size = groups.get(curGroupId).size();
            if (size == 0) {
                continue;
            }
            List<Integer> res = topSort(itemInDegree, groups.get(curGroupId), itemGraph);
            if (res.size() == 0) {
                return new int[0];
            }
            for (int item : res) {
                ans[index++] = item;
            }
        }

        return ans;
    }

    public List<Integer> topSort(int[] inDegree, List<Integer> prefixs, List<List<Integer>> items) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer prefix : prefixs) {
            if (inDegree[prefix] == 0) {
                queue.offer(prefix);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for (int item : items.get(curr)) {
                if (--inDegree[item] == 0) queue.offer(item);
            }
        }

        return result.size() == prefixs.size() ? result : new ArrayList<>();
    }

}