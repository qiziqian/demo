package com.example.qzq.重构.demo1.fresh;

/**
 * @ClassName : EmployeeType
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-11 10:38
 */
public abstract class EmployeeType {
    //int abstract payAmount();
    abstract int getTypeCode();

    abstract int payAmount(Employee employee);


}