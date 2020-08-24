package com.example.qzq.深入理解java虚拟机.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 泛型擦除式泛型
 * @Date 2020/2/21 9:35
 * @Author by qiziqian
 */
public class TypeErasureGenerics<E> {
    public static void doSomething(Object item) {
        //泛型擦除式泛型 不支持的用法
//        if(item instanceof  E){
//
//        }
//        E newItem = new E();
//
//        E[] itemArray = new E[10];
    }

    public static void doSomething2() {
        //编译期不报错,运行期报错
        Object[] array = new String[10];
        array[0] = 10;
        // 编译期,运行期都不报错
        ArrayList things = new ArrayList();
        things.add(Integer.valueOf(10));
        things.add("hello world");
    }

    public static void doSomething3() {
        //裸类型替换,父类接收子类对象
        ArrayList<Integer> ilist = new ArrayList();
        ArrayList<String> slist = new ArrayList();
        ArrayList list;
        list = ilist;
        list = slist;
    }

    public static void doSomething4() {
        //泛型擦除前的例子    请查看class文件,即为泛型擦除后的例子
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "world");
        map.put("hello2", "world2");
        System.out.println(map.get("hello"));
        System.out.println(map.get("hello2"));

    }

    public static void primitiveTypes() {
        //原始类型的泛型  java不支持  需要装箱成包装类型再转型成Object
//        ArrayList<int> ilist = new ArrayList();
//        ArrayList<long> llist = new ArrayList();
//        ArrayList list;
//        list = ilist;
//        list = llist;
    }

    public static void main(String[] args) {
        doSomething4();
    }
}
