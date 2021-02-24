package com.example.qzq.acwing.二分;

/**
 * @ClassName : BinarySearch
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-24 11:17
 */
public class BinarySearch {

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