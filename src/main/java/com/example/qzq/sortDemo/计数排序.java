package com.example.qzq.sortDemo;

/**
 * @Classname 计数排序
 * @Description
 * @Date 2019/10/29 14:26
 * @Created by qiziqian
 */
public class 计数排序 {
    public static void main(String[] args) {
        //计算6名考生的排名
        //当前这个数组,下标代表一个人的id,value代表成绩
        int[] arr = {12, 88, 91, 94, 59, 0};
        // countingSort(arr,6);
        //拿到最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        //循环最大值,拿到成绩排名 (数组下标为成绩,value为)
        int[] score = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            score[arr[i]]++;
        }
        for (int i = score.length - 2; i >= 0; i--) {
            score[i] = score[i + 1] + score[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = score[arr[i]];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    //从极客时间拿到的实例代码,感觉结果不太对
    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}
