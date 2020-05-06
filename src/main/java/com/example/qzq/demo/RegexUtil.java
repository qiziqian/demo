package com.example.qzq.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname RegexUtil
 * @Description
 * @Date 2020/4/24 15:29
 * @Created by qiziqian
 */
public class RegexUtil {
    //匹配库位标签,库位标签为纯数字
    private  static  final  Pattern pattern = Pattern.compile("^[0-9]*");

    static boolean verifyStorageBinTag(String tag){
        return  pattern.matcher(tag).matches();
    }

    public static void main(String[] args) {
        System.out.println(verifyStorageBinTag("1q2qe3"));
    }
}
