package com.example.qzq.重构.demo1.fresh;

/**
 * @ClassName : Engineer
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-11 10:43
 */
public class Engineer extends EmployeeType {

    @Override
    int getTypeCode() {
        return EMPLOYEE_TYPE.ENGINEER.getTypeCode();
    }

    @Override
    int payAmount(Employee employee) {
        return employee.getMonthlySalary();
    }
}