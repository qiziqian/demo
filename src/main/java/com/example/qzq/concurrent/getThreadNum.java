package com.example.qzq.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Classname getThreadNum
 * @Description 获取当前程序执行使用的线程数
 * @Date 2019/8/18 17:22
 * @Created by qiziqian
 */
public class getThreadNum {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("线程Id: " + threadInfo.getThreadId() + " 线程名称" + threadInfo.getThreadName());
        }
    }
}
