package com.example.qzq.acwing.快速排序;


/**
 * @Description
 * @Date 2021/2/16 8:56
 * @Author by qiziqian
 */
public class QuickSort {

    /*
      基于分治算法
      第一步: 确定分界点:
        1.q[l];
        2.q[(l+r)/2];
        3.q[randow]
      第二步:
        调整范围,把所有小于分界点的数放到他左边,大于分界点的数放到他右边
      第三步:
        递归/迭代处理左右两段
     */

    public static void quickSort(int q[], int l, int r) {
        if (l >= r) return;
        int x = q[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }

    //为什么用j而不是i当做分界点?:确保分段后右侧全部大于左侧
    public static void main(String[] args) {
        int[] ints = {2, 3, 5, 1};
        quickSort(ints, 0, ints.length - 1);
        for (int n : ints) {
            System.out.print(n + " ");
        }
    }
}
