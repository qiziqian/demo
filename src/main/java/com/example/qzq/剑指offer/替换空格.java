package com.example.qzq.剑指offer;

/**
 * @ClassName : 替换空格
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-30 11:13
 */
public class 替换空格 {
    public static void main(String[] args) {
        System.out.println(replaceSpace(""));
    }


    //不可行,因为可能出现多个空格相连的情况
//    public String replaceSpace(String s) {
//        String[] strArray = s.split(" ");
//
//        StringBuilder strBuilder = new StringBuilder();
//
//        for(int i =0;i<strArray.length;i++){
//            strBuilder.append(strArray[i]);
//            if(i!=strArray.length-1)strBuilder.append("%20");
//        }
//
//        return strBuilder.toString();
//    }

    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }

        }
        return stringBuilder.toString();
    }
}