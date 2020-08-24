package com.example.qzq.深入理解java虚拟机.staticResolution;

/**
 * @Description 字段不参与多态
 * @Date 2020/2/19 15:01
 * @Author by qiziqian
 */
public class FieldHasNotPolymorphic {

    public static void main(String[] args) {
        Father man = new Son();
        System.out.println("This guy  have " + man.money + " dollars");
    }

    static class Father {
        int money = 1;

        Father() {
            money = 2;
            showMeTheMoney();
        }

        void showMeTheMoney() {
            System.out.println("I am Father,I have " + money + "dollars");
        }
    }

    static class Son extends Father {
        int money = 3;

        Son() {
            money = 4;
            showMeTheMoney();
        }

        @Override
        void showMeTheMoney() {
            System.out.println("I am Son,I have " + money + "dollars");
        }
    }
}
