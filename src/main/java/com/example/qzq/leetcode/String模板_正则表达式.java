package com.example.qzq.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname String模板_正则表达式
 * @Description
 * @Date 2019/10/8 12:55
 * @Created by qiziqian
 */
public class String模板_正则表达式 {
    public static void main(String[] args) {
//        String s ="字符串占位符测试${%zzzzz%},占位{%leetcode%}";
//        HashMap<String, String> map = new HashMap<>();
//        map.put("leetcode","qqqqq");
//        map.put("zzzzz","yyyy");
//
//        Pattern mPattern = Pattern.compile("\\$\\{%(.*)%}");
//        Matcher mMatcher = mPattern.matcher(s);
//        while (mMatcher.find()) {
//            String find = mMatcher.group(1);
//            s = s.replace(mMatcher.group(0), map.get(find));
//        }
//        System.out.println(s);
        String s = "{生日:{%birthday%} 年龄:{%age%} 性别:{%sex%}}";
        Map<String, String> map = new HashMap<String, String>();
        map.put("birthday", "19960531");
        map.put("age", "22");
        //  map.put("sex", "男");
        System.out.println(replaceString(s, map));
    }

    public static String replaceString(String s, Map<String, String> map) {
        Pattern pattern = Pattern.compile("\\{%(.*?)%}");
        Matcher matcher = pattern.matcher(s);
        try {
            while (matcher.find()) {
                String find = matcher.group(1);
                s = s.replace(matcher.group(0), map.get(find));
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return s;
    }
}
