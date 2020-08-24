package com.example.qzq.重构.demo1.fresh;

/**
 * @ClassName : Manager
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-11 10:58
 */
public class Manager extends EmployeeType {

    @Override
    int getTypeCode() {
        return 0;
    }

    @Override
    int payAmount(Employee employee) {
        return employee.getMonthlySalary() + employee.getCommission();
    }
}