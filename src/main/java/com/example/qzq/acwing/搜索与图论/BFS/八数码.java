package com.example.qzq.acwing.搜索与图论.BFS;

import java.util.*;

/**
 * @ClassName : 八数码
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-09 14:10
 */
public class 八数码 {

    static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String start = "";
        for (int i = 0; i < 9; i++) {
            start += sc.next();
        }
        System.out.println(bfs(start.toCharArray()));
    }

    public static int bfs(char[] start) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(new String(start));
        String end = "12345678x";
        Map<String, Integer> map = new HashMap<>();
        map.put(new String(start), 0);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            char[] chars = s.toCharArray();
            int index = s.indexOf("x");
            int distance = map.get(s);
            for (int i = 0; i < direction.length; i++) {
                int x = index / 3 + direction[i][0];
                int y = index % 3 + direction[i][1];
                if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                    int newIndex = x * 3 + y;
                    chars[index] = chars[newIndex];
                    chars[newIndex] = 'x';

                    String curr = new String(chars);
                    if (!map.containsKey(curr)) {
                        map.put(curr, distance + 1);
                        if (curr.equals(end)) return distance + 1;
                        queue.add(curr);
                    }
                    chars[newIndex] = chars[index];
                    chars[index] = 'x';
                }
            }
        }
        return -1;
    }
}