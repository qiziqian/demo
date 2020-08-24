package com.example.qzq.work;

import java.util.HashMap;

/**
 * @ClassName : computeIfAbsentTest
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-14 17:50
 */
public class computeIfAbsentTest {
    public static void main(String[] args) {
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        //objectObjectHashMap.put("123","456");
        objectObjectHashMap.put("456", "666");
        objectObjectHashMap.putIfAbsent("123", "777");
        System.out.println(objectObjectHashMap);
    }
}