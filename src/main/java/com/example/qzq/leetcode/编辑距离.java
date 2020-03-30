package com.example.qzq.leetcode;

/**
 * @Classname 编辑距离
 * @Description
 * @Date 2019/11/22 11:26
 * @Created by qiziqian
 */
public class 编辑距离 {
    public static void main(String[] args) {
        String s1 = "pneumonoultramicroscopicsilicovolcanoconiosis";
        String s2 = "ultramicroscopically";
        lwstDP(s1.toCharArray(), s1.length(), s2.toCharArray(), s2.length());
        System.out.println();
        minDistance(s1, s2);
    }

    //老师的
    public static int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        minDist[0][0] = a[0] == b[0] ? 0 : 1;
        boolean flag1 = minDist[0][0] == 1;//flag1,flag2均为哨兵,判断与[0,0]相同的第一个值出现的时机
        for (int j = 0; j < m; ++j) { // 初始化第0行:a[0..0]与b[0..j]的编辑距离
            if (flag1 && a[0] == b[j]) {
                minDist[0][j] = minDist[0][j - 1];
                flag1 = false;
                continue;
            }
            minDist[0][j] = minDist[0][j - 1] + 1;
        }
        boolean flag2 = minDist[0][0] == 1;
        for (int i = 0; i < n; ++i) { // 初始化第0列:a[0..i]与b[0..0]的编辑距离
            if (flag2 && a[i] == b[0]) {
                minDist[i][0] = minDist[i - 1][0];
                flag2 = false;
                continue;
            }
            minDist[i][0] = minDist[i - 1][0] + 1;
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) minDist[i][j] = min(
                        minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                else minDist[i][j] = min(
                        minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(minDist[i][j] + " ");
            }
            System.out.println();
        }
        return minDist[n - 1][m - 1];
    }

    private static int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }

    //我的
    public static int minDistance(String word1, String word2) {
        if (word1.length() < 1 || word2.length() < 1) {
            return word1.length() < 1 ? word2.length() : word1.length();
        }
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int[][] dist = new int[ch1.length][ch2.length];
        dist[0][0] = ch1[0] == ch2[0] ? 0 : 1;
        //初始化第一行和第一列
        //问题出现在第一次出现匹配的字符的情况时,只有第一次匹配的时候不+1,第二次,第三次出现匹配的时候还得+1
        boolean flag = dist[0][0] == 1;
        for (int i = 1; i < ch1.length; i++) {
            if (flag && ch1[i] == ch2[0]) {
                dist[i][0] = dist[i - 1][0];
                flag = false;
                continue;
            }
            dist[i][0] = dist[i - 1][0] + 1;
        }
        boolean flag2 = dist[0][0] == 1;
        for (int i = 1; i < ch2.length; i++) {
            if (flag2 && ch1[0] == ch2[i]) {
                dist[0][i] = dist[0][i - 1];
                flag2 = false;
                continue;
            }
            dist[0][i] = dist[0][i - 1] + 1;
        }
        //初始化矩阵内数据
        for (int i = 1; i < ch1.length; i++) {
            for (int j = 1; j < ch2.length; j++) {
                dist[i][j] = ch1[i] == ch2[j] ? getMin(dist[i - 1][j - 1], dist[i - 1][j] + 1, dist[i][j - 1] + 1) : getMin(dist[i - 1][j - 1] + 1, dist[i - 1][j] + 1, dist[i][j - 1] + 1);
            }
        }

        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        return dist[ch1.length - 1][ch2.length - 1];
    }

    public static int getMin(int dist1, int dist2, int dist3) {
        return Math.min(Math.min(dist1, dist2), dist3);
    }

    public int lwstDP2(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        minDist[0][0] = a[0] == b[0] ? 0 : 1;
        boolean flag1 = minDist[0][0] == 1;//flag1,flag2均为哨兵,判断与[0,0]相同的第一个字符出现的时机
        for (int j = 1; j < m; ++j) { // 初始化第0行:a[0..0]与b[0..j]的编辑距离
            //第一次出现与[0,0]相同的字符,不改变
            if (flag1 && a[0] == b[j]) {
                minDist[0][j] = minDist[0][j - 1];
                flag1 = false;
                continue;
            }
            minDist[0][j] = minDist[0][j - 1] + 1;
        }
        boolean flag2 = minDist[0][0] == 1;
        for (int i = 1; i < n; ++i) { // 初始化第0列:a[0..i]与b[0..0]的编辑距离
            //第一次出现与[0,0]相同的字符,不改变
            if (flag2 && a[i] == b[0]) {
                minDist[i][0] = minDist[i - 1][0];
                flag2 = false;
                continue;
            }
            minDist[i][0] = minDist[i - 1][0] + 1;
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) minDist[i][j] = min(
                        minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                else minDist[i][j] = min(
                        minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
            }
        }
        return minDist[n - 1][m - 1];
    }

}
