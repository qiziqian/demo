package com.example.qzq.acwing.数据结构.哈希;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName : 模拟散列表
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-06 10:50
 */
public class 模拟散列表 {
        /*
        开放寻址法
        链表法

        散列表长度最好是个质数,离2的整数次方远一些,这样冲突的概率是最小的
        */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        OpenAddressHashMap map = new OpenAddressHashMap();

        while (m-- > 0) {
            String opt = scanner.next();
            int x = scanner.nextInt();
            if ("I".equals(opt)) {
                map.insert(x);
            } else {
                System.out.println(map.find(x) ? "Yes" : "No");
            }
        }


    }


    public static class MyLinkedMap {
        int N = 100007;
        int[] h = new int[N];
        int[] ne = new int[N];
        int[] e = new int[N];
        int idx = 0;

        public MyLinkedMap() {
            Arrays.fill(h, -1);
        }

        public void insert(int x) {
            int k = (x % N + N) % N;
            e[idx] = x;
            ne[idx] = h[k];
            h[k] = idx++;
        }


        public boolean find(int x) {
            int k = (x % N + N) % N;
            for (int i = h[k]; i != -1; i = ne[i]) {
                if (e[i] == x) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class OpenAddressHashMap {

        int N = 100007;
        int[] h = new int[N];

        public OpenAddressHashMap() {
            Arrays.fill(h, -1);
        }

        public void insert(int x) {
            int k = (x % N + N) % N;
            while (h[k] != -1) {
                k++;
            }
            h[k] = x;
        }

        public boolean find(int x) {
            int k = (x % N + N) % N;
            while (k < N && h[k] != x) {
                k++;
            }
            return k != N;
        }


    }
}