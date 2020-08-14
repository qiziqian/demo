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
    private static final Pattern pattern = Pattern.compile("^[0-9]*");
    private static final Pattern pattern1 = Pattern.compile("^[0-9]{4}|88998806[0-9|a-z|A-Z]*");

    static boolean verifyStorageBinTag(String tag){
        return pattern1.matcher(tag).matches();
    }

    public static void main(String[] args) {

        System.out.println(verifyStorageBinTag("88998806eASDAd6a"));
        System.out.println(verifyStorageBinTag("1234"));

    }
}
