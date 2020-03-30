package com.example.qzq.geekbang;

/**
 * @Classname BoyerMoore
 * @Description
 * @Date 2019/11/11 13:35
 * @Created by qiziqian
 */
public class BoyerMoore {
    private final int SIZE = 256;

    //b为模式串的字符数组,m为b的大小,bc为散列表
    private void gnerateBC(char[] b, int m, int[] bc) {
        //初始化bc
        for (int i = 0; i < bc.length; i++) {
            bc[i] = -1;
        }
        //将ascii存在散列表中
        for (int i = 0; i < b.length; i++) {
            int ascii = b[i];
            bc[ascii] = i;
        }
    }

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE];
        gnerateBC(b, m, bc);

        int i = 0;
        while (i < n - m) {
            int j;
            for (j = m - 1; j >= 0; j--) {
                if (a[i + j] != b[j]) break;
            }
            if (j < 0) {
                return i;   //匹配成功,返回
            }
            i = i + (j - bc[a[i + j]]);   //匹配失败,去匹配下一段字符
        }
        return -1; //没找到,返回-1
    }


}
