package com.example.qzq.深入理解java虚拟机.gc;

/**
 * @Description 局部变量表 复用变量槽对垃圾收集的影响    vm参数 : -verbose:gc
 * @Date 2020/2/18 10:29
 * @Author by qiziqian
 */
public class LocalVariableTable {
//    public static void main(String[] args) {
//        byte[] placeholder =  new byte[64*1024*1024];
//        System.gc();
//    }

    //    public static void main(String[] args) {
//        {
//            byte[] placeholder = new byte[64 * 1024 * 1024];
//        }
//        System.gc();
//    }
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
