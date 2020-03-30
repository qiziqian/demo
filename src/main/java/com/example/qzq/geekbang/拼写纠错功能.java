package com.example.qzq.geekbang;

/**
 * @Classname 拼写纠错功能
 * @Description 动态规划练习
 * @Date 2019/11/21 14:31
 * @Created by qiziqian
 */
public class 拼写纠错功能 {

    //回溯算法-莱文斯坦距离
    private static char[] ch1 = "mitcmu".toCharArray();
    private static char[] ch2 = "mtacnu".toCharArray();
    private int minDist = Integer.MAX_VALUE;

    //动态规划-莱文斯坦距离
    public static int lwstBT() {
        int[][] dist = new int[ch1.length][ch2.length];
        dist[0][0] = ch1[0] == ch2[0] ? 0 : 1;
        //初始化第一行和第一列
        for (int i = 1; i < ch1.length; i++) {
            dist[i][0] = dist[i - 1][0] + 1;
        }
        for (int i = 1; i < ch2.length; i++) {
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

    public static void main(String[] args) {
        lwstBT();
    }

    public void minDist(int i, int j, int edist) {
        if (i == ch1.length || j == ch2.length) {
            if (i < ch1.length) edist += ch1.length - i;
            if (j < ch2.length) edist += ch2.length - j;
            minDist = Math.min(minDist, edist);
            return;
        }
        if (ch1[i] == ch2[j]) {
            minDist(i + 1, j + 1, edist);
        } else {
            minDist(i + 1, j, edist + 1);
            minDist(i, j + 1, edist + 1);
            minDist(i + 1, j + 1, edist + 1);
        }
    }
}
