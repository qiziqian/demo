package com.example.qzq.编程珠玑.开篇题;

/**
 * @ClassName : 税率计算
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-01 17:21
 */
public class 税率计算 {


    int[] array1 = new int[]{2200, 2700, 3500, 4200};
    int[] array2 = new int[]{111, 111, 111, 111};
    int[] array3 = new int[]{0, 23, 23, 23, 23, 23};

    public static void main(String[] args) {

    }

    public static double calculate(int money) {
        double tax = 0.0;
        if (money < 2200) {
            tax = 0;
        } else if (money < 2700) {
            tax = 0.14 * (money - 2200);
        } else if (money < 3200) {
            tax = 111 + 0.15 * (money - 4200);
        } else if (money < 3700) {
            tax = 111 + 0.16 * (money - 4200);
        } else if (money < 4200) {
            tax = 111 + 0.17 * (money - 4200);
        }
        return tax;

    }

}