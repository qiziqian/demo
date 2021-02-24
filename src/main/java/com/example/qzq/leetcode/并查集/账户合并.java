package com.example.qzq.leetcode.并查集;

import java.util.*;

/**
 * @ClassName : 账户合并
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-18 10:25
 */
public class 账户合并 {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("johnsmith@mail.com");
        list1.add("john_newyork@mail.com");
        List<String> list2 = new ArrayList<>();
        list2.add("John");
        list2.add("johnsmith@mail.com");
        list2.add("john00@mail.com");
        List<String> list3 = new ArrayList<>();
        list3.add("Mary");
        list3.add("mary@mail.com");
        List<String> list4 = new ArrayList<>();
        list4.add("John");
        list4.add("johnnybravo@mail.com");
        accounts.add(list1);
        accounts.add(list2);
        accounts.add(list3);
        accounts.add(list4);


        accountsMerge(accounts);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList();
        // Map<String, List<String>> accountMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        int index = 0;
        //创建索引
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 0; j < account.size(); j++) {
                String mail = account.get(j);
                indexMap.put(mail, index++);
            }

        }

        //创建并查集,合并关系
        UnionSet unionSet = new UnionSet(index);
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 2; j < account.size(); j++) {
                int index1 = indexMap.get(account.get(j - 1));
                int index2 = indexMap.get(account.get(j));
                unionSet.union(index1, index2);
            }
        }

        Map<String, Map<Integer, List<String>>> resultMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            if (!resultMap.containsKey(name)) resultMap.put(name, new HashMap<>());
            Map<Integer, List<String>> unionMap = resultMap.get(name);
            for (int j = 1; j < account.size(); j++) {
                int root = unionSet.find(indexMap.get(account.get(j)));
                if (!unionMap.containsKey(root)) {
                    unionMap.put(root, new ArrayList<>());
                }
                if (!unionMap.get(root).contains(account.get(j))) unionMap.get(root).add(account.get(j));
            }

        }

        for (Iterator<Map.Entry<String, Map<Integer, List<String>>>> iterator = resultMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Map<Integer, List<String>>> entry = iterator.next();
            String name = entry.getKey();
            for (Iterator<Map.Entry<Integer, List<String>>> unionMap = entry.getValue().entrySet().iterator(); unionMap.hasNext(); ) {
                Map.Entry<Integer, List<String>> next = unionMap.next();
                List<String> value = next.getValue();
                Collections.sort(value);
                value.add(0, name);
                result.add(value);
            }

        }

        return result;
    }

    private static class UnionSet {

        int[] parent;
        int[] rank;

        public UnionSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

    }
}