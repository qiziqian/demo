package com.example.qzq.深入理解java虚拟机.clinit;

/**
 * @Description 初始化时线程阻塞 演示
 * @Date 2020/2/16 16:44
 * @Author by qiziqian
 */
public class DeadLoopClass {
    static {
        //如果不加if,编译器将会提示 "...."
        if (true) {
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while (true) {

            }
        }
    }
}
