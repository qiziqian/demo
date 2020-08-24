package com.example.qzq.重构.demo1.fresh;

/**
 * @ClassName : EMPLOYEE_TYPE
 * @Author : qiziqian
 * @Description :
 * @Date: 2020-08-11 10:41
 */
public enum EMPLOYEE_TYPE {
    ENGINEER(1),
    SALESMAN(2),
    MANAGER(3);
    private int typeCode;

    EMPLOYEE_TYPE(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getTypeCode() {
        return this.typeCode;
    }
}
