package com.example.qzq.leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @ClassName : 除法求值
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-06 10:33
 */
public class 除法求值 {
    public static void main(String[] args) {
        String str = "888;999;33234324;345;43531";
        String aaa = "888;999";

        String[] strArray = str.split(";");
        String[] aaaArray = aaa.split(";");

        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        for (String s : strArray) {
            set1.add(s);
        }
        for (String s : aaaArray) {
            set2.add(s);
        }
        set1.removeAll(set2);
        System.out.println(set1);


    }

    public static double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)),
                    vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList();
                    points.offer(ia);
                    double[] ratios = new double[nvars];
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;

                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int numCount = 0;
        //初始化字母与index的映射关系
        Map<String, Integer> map = new HashMap<>();
        for (List<String> equation : equations) {
            if (!map.containsKey(equation.get(0))) {
                map.put(equation.get(0), numCount++);
            }
            if (!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), numCount++);
            }
        }

        //构建图
        List<Pair>[] graph = new List[numCount];
        for (int i = 0; i < numCount; i++) {
            graph[i] = new ArrayList();
        }
        //初始化图
        for (int i = 0; i < equations.size(); i++) {
            int start = map.get(equations.get(i).get(0));
            int end = map.get(equations.get(i).get(1));
            graph[start].add(new Pair(end, values[i]));
            graph[end].add(new Pair(start, 1.0 / values[i]));
        }
        //结果集
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            double curr = -1.0;
            List<String> query = queries.get(i);

            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                //特例判断
                if (query.get(0).equals(query.get(1))) {
                    curr = 1.0;
                } else {
                    //bfs
                    int start = map.get(query.get(0));
                    int target = map.get(query.get(1));

                    double[] ratios = new double[numCount];
                    Arrays.fill(ratios, -1.0);
                    ratios[start] = 1.0;

                    Queue<Integer> points = new LinkedList();
                    points.offer(start);
                    while (!points.isEmpty() && ratios[target] < 0) {
                        Integer point = points.poll();
                        for (Pair pair : graph[point]) {
                            int index = pair.index;
                            double value = pair.value;
                            if (ratios[index] < 0) {
                                ratios[index] = ratios[point] * value;
                                points.offer(index);
                            }

                        }
                    }
                    curr = ratios[target];

                }
            }

            result[i] = curr;
        }
        return result;
    }

    static class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}

