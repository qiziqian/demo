package com.example.qzq.geekbang;

/**
 * @Classname O1背包
 * @Description 0-1背包及其变体
 * @Date 2019/11/18 13:42
 * @Created by qiziqian
 */
public class O1背包 {

    public int maxW = Integer.MIN_VALUE;
    public int maxV = Integer.MIN_VALUE;
    private int n = 5;     //物品数量
    private int w = 100;    //背包能承受的重量
    private int[] item = {21, 30, 5, 28, 41};   //货品重量
    private int[] itemV = {15, 7, 35, 14, 28};   //货品价值

    private boolean[][] mem = new boolean[5][10]; // 备忘录，默认值false

    //如果背包重量为w,货品重量为weight,货品价值为value,货品数量为n,求能存放货品的最大价值
    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        //初始化数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j < w - weight[i]; j++) {
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j + weight[i]] + value[i];
                    if (v > states[i][weight[i] + j]) {
                        states[i][weight[i] + j] = v;
                    }
                }
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i <= w; i++) {
            if (states[n - 1][i] > maxValue) maxValue = states[n - 1][i];
        }
        return maxValue;
    }

    //双十一凑单问题,如何凑满200-50
    // items商品价格，n商品个数, w表示满减条件，比如200
    public static void double11advance(int[] items, int n, int w) {
        boolean[][] states = new boolean[n][3 * w + 1];
        states[0][0] = true;
        if (items[0] <= w) states[0][items[0]] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3 * w; j++) {
                if (states[i - 1][j]) states[i][j] = true;
            }
            for (int j = 0; j <= 3 * w - items[i]; j++) {
                if (states[i - 1][j]) states[i][j + items[i]] = true;
            }
        }
        int j;
        for (j = w; j < 3 * w + 1; j++) {
            if (states[n - 1][j]) {
                break;
            }
        }
        if (j == 3 * w + 1) return;
        //这种做法其实不准确,即使有多条路径满足条件,以下方法也只能找到其中一条
        for (int i = 0; i < n - 1; i++) {
            if (j - items[i] >= 0 && states[i - 1][j - items[i]]) {
                //其实应该再有一个数组,存储商品的名字
                System.out.println("买了价值为" + items[i] + "的商品");
                j = j - items[i];
            }
        }
        if (j != 0) System.out.println(items[0]);
    }

    //贪心算法实现:背包能承受的总重量一定,每件物品的重量可变,而且物品的价值不同,问能放进背包的价值最大是多少

    /**
     * Author qiziqian
     * Description  回溯算法实现: 背包能承受的总重量一定,每件物品的重量一定,不可分割,问能放进背包的最大重量是多少
     * 优化后的回溯,添加了备忘录
     * Date  2019/11/18
     * return
     **/
    public void f(int i, int cw) {
        if (i == n || cw == w) {
            if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return;   //重复状态
        mem[i][cw] = true;
        f(i + 1, cw);
        if (cw + item[i] <= w) {
            f(i + 1, cw + item[i]);
        }
    }

    //求能装下的货品的最大价值
    public void f2(int i, int cw, int cv) {
        if (i == n || cw == w) {
            if (cv > maxV) maxV = cv;
            return;
        }
        f2(i + 1, cw, cv);
        if (cw + item[i] <= w) {
            f2(i + 1, cw + item[i], cv + itemV[i]);
        }
    }

    //动态规划实现:
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        if (weight[0] <= w) states[0][weight[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < w; j++) {
                if (states[i - 1][j]) states[i][j] = true;
            }
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j]) states[i][weight[i] + j] = true;
            }
        }
        for (int i = w; i >= 0; i++) {
            if (states[n - 1][i]) return i;
        }
        return 0;
    }

    //动态规划优化,将二维数组改为一维数组
    public int knapsack2(int[] weight, int n, int w) {
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        if (weight[0] <= w) states[weight[0]] = true;
        for (int i = 1; i < n; i++) {
            //j从下到大开始计算,如果j从小到大来处理，states[j+items[i]] = true;这个赋值会影响后续的处理
            //TODO
            for (int j = w - weight[i]; j >= 0; j--) {
                if (states[j]) states[j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; i--) {
            if (states[i]) return i;
        }
        return 0;
    }

}
