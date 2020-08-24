package com.example.qzq.深入理解java虚拟机.staticResolution;

/**
 * @Description 单分派与多分派的演示
 * @Date 2020/2/19 15:14
 * @Author by qiziqian
 */
public class Dispatch {
    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }

    static class QQ {

    }

    static class _360 {

    }

    static class Father {
        void hardChoice(QQ qq) {
            System.out.println("father choice qq");
        }

        void hardChoice(_360 _360) {
            System.out.println("father choice 360");
        }
    }

    static class Son extends Father {
        @Override
        void hardChoice(QQ qq) {
            System.out.println("son choice qq");
        }

        @Override
        void hardChoice(_360 _360) {
            System.out.println("son choice 360");
        }
    }
}
