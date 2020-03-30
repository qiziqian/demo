package com.example.qzq.jvm.generics;

import java.util.List;

/**
 * @Description 泛型与方法重载
 * @Date 2020/2/21 9:52
 * @Author by qiziqian
 */
public class GenericTypesAndOverLoad {
    static class Test1 {
        //泛型擦除后不可编译
//        public  static  void method(List<String> list){
//            System.out.println("invoke method( List<String> list )");
//        }
//        public  static  void method(List<Integer> list){
//            System.out.println("invoke method( List<Integer> list )");
//        }
    }

    static class Test2 {
        //只有jdk6可以编译
//        public  static  String method(List<String> list){
//            System.out.println("invoke method( List<String> list )");
//            return "";
//        }
//        public  static  int method(List<Integer> list){
//            System.out.println("invoke method( List<Integer> list )");
//            return 1;

//        }
    }

}
