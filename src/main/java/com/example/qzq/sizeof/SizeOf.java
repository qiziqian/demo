package com.example.qzq.sizeof;

import org.apache.lucene.util.RamUsageEstimator;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Classname SizeOf
 * @Description
 * @Date 2020/2/27 13:39
 * @Created by qiziqian
 */
public class SizeOf {


    public static void main(String[] args) {
        getSizeOfBasic();
        getSizeOfWrapper();
    }

    static void getSizeOfBasic() {
        LongObject2 longObject = new LongObject2();
        longObject.setTest1(1L);
        System.out.println("------------基本类型----------");
        System.out.println("占用的堆内存: " + RamUsageEstimator.shallowSizeOf(longObject));
        System.out.println("占用的总内存: " + RamUsageEstimator.humanSizeOf(longObject));
    }

    static void getSizeOfWrapper() {
        LongObject longObject = new LongObject();
        longObject.setTest1(1L);
        System.out.println("------------包装类型----------");
        System.out.println("占用的堆内存: " + RamUsageEstimator.shallowSizeOf(longObject));
        System.out.println("占用的总内存: " + RamUsageEstimator.humanSizeOf(longObject));
    }

    static void getSizeOfOneMap() {
        HashMap<Long, Long> longMap = new HashMap<>();
        longMap.put(1L, 2L);
        longMap.put(3L, 4L);
        longMap.put(5L, 6L);
        System.out.println("------------longMap----------");
        System.out.println("占用的堆内存: " + RamUsageEstimator.shallowSizeOf(longMap));
        System.out.println("占用的总内存: " + RamUsageEstimator.humanSizeOf(longMap));
    }

    static void getSizeOfOneHundred() {
        System.out.println("------------longObject array----------");
        LongObject longObject = new LongObject();
        longObject.setTest1(1L);
        //longObject.setTest2(2L);
        LongObject[] array = new LongObject[100];
        ArrayList<LongObject> list = new ArrayList<>();
        ArrayList<LongObject> list2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            array[i] = longObject;
            list.add(longObject);
        }
        System.out.println("空数组占用堆内存: " + RamUsageEstimator.shallowSizeOf(list2));
        System.out.println("空数组占用的总内存: " + RamUsageEstimator.humanSizeOf(list2));
        System.out.println("100个LongObject的数组占用的堆内存: " + RamUsageEstimator.shallowSizeOf(list));
        System.out.println("100个LongObject占用的总内存: " + RamUsageEstimator.humanSizeOf(list));


        System.out.println("------------longMap----------");
        HashMap<Long, Long> longMap = new HashMap<>();
        Long j = 1000L;
        for (Long i = 1L; i <= 100L; i++) {
            longMap.put(i, j--);
        }
        System.out.println("占用的堆内存: " + RamUsageEstimator.shallowSizeOf(longMap));
        System.out.println("占用的总内存: " + RamUsageEstimator.humanSizeOf(longMap));
    }
}
