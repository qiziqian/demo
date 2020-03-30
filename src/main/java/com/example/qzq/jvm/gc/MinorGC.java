package com.example.qzq.jvm.gc;

import com.example.qzq.data_structure.Graph;

import java.util.ArrayList;
import java.util.HashMap;

// -XX:+UseSerialGC
//JDK版本?
public class MinorGC {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        HashMap<Object, Object> map = new HashMap<>();
        Graph graph = new Graph(3);
        System.out.println("done");
        //  testallocation4();
    }

    //对象优先在Eden区产生 验证失败,大对象直接进入老年代
    public static void testallocation1() {
        //-verbose:jvm -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    //大对象直接进入老年代 验证成功.但是新生代为什么占用将近3MB的内存?
    public static void testallocation2() {
        //-verbose:jvm -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    //长期存活对象将放入老年代 验证失败
    public static void testallocation3() {
        //-verbose:jvm -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
        //-verbose:jvm -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    //动态年龄判定  失败,未出现相应的情况
    public static void testallocation4() {
        //-verbose:jvm -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution

        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }
    //空间分配担保
}
