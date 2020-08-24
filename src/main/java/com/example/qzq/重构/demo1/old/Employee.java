package com.example.qzq.重构.demo1.old;

/**
 * @ClassName : Employee
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-11 10:31
 */
public class Employee {

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 0;
    private int type;
    private int monthlySalary;
    private int commission;
    private int bonus;

    Employee(int _type) {
        this.type = type;
    }

    int payAmount() {
        switch (type) {
            case 1:
                return monthlySalary;
            case 2:
                return monthlySalary + commission;
            case 3:
                return monthlySalary + bonus;
            default:
                throw new RuntimeException("");
        }
    }
}