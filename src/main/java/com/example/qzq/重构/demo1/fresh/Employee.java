package com.example.qzq.重构.demo1.fresh;

import lombok.Data;

/**
 * @ClassName : Employee
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-11 10:31
 */
@Data
public class Employee {

    private EmployeeType type;
    private int monthlySalary;
    private int commission;
    private int bonus;

    Employee(EmployeeType type) {
        this.type = type;
    }

    int payAmount() {
        return type.payAmount(this);
    }
}