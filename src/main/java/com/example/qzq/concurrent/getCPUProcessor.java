package com.example.qzq.concurrent;

/**
 * @Classname getCPUProcessor
 * @Description 获取CPU可用线程数
 * @Date 2019/8/18 16:57
 * @Created by qiziqian
 */
public class getCPUProcessor {
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu可用线程数:" + availableProcessors);

    }
}
