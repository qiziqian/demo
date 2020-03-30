package com.example.qzq.jvm.load;

import com.example.qzq.jvm.load.ConstClass;

/**
 * @Description
 * @Date 2020/2/16 9:59
 * @Author by qiziqian
 */
public class Notinitialization {
    public static void main(String[] args) {
        //被动引用1  只会初始化父类
        //System.out.println(SubClass.value);
        //被动引用2: 通过数组定义引用类,不用触发类的初始化
        //SuperClass[] array = new SuperClass[1];
        //被动引用3: 常量在编译阶段会存入调用类的常量池里,本质上没有直接引用到定义常量的类,因此不会触发定义常量的类的初始化
        System.out.println(ConstClass.HELLOWORLD);
    }
}
