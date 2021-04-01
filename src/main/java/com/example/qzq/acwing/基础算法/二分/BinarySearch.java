package com.example.qzq.acwing.基础算法.二分;

/**
 * @ClassName : BinarySearch
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-24 11:17
 */
public class BinarySearch {
    /*
        整数二分通用模板

        注意:
            有单调性一定可以二分,没有单调性也可能用二分
            二分的核心并不是单调性,而是区间中符合某一性质的子区间边界


        二分步骤:
        1.找到一个中间点 mid
        2.让其中一段符合某种性质,然后判断mid符不符合性质,然后更新端点
     */
    /*
        区间被划分成 [l,mid-1]和[mid,r]
     */


    public int binarySearch1(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    /*
        区间被划分成 [l,mid]和[mid+1,r]
     */
    public int binarySearch2(int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    //判断mid是否满足某种性质
    public boolean check(int mid) {
        return true;
    }

}