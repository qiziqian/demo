package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Classname 两句话中的不常见单词
 * @Description
 * @Date 2019/10/8 9:26
 * @Created by qiziqian
 */
public class 两句话中的不常见单词 {
    public static void main(String[] args) {
        String[] strings = uncommonFromSentences("this apple is sweet", "this apple is sour");
        Arrays.stream(strings).forEach(System.out::println);
    }

    public static String[] uncommonFromSentences(String A, String B) {
        List<String> list = Arrays.asList((A + " " + B).split(" "));
        ArrayList<Object> objects = new ArrayList<>();
        HashSet set = new HashSet();

        for (int i = 0; i < list.size(); i++) {
            if (!set.contains(list.get(i))) {
                set.add(list.get(i));
                objects.add(list.get(i));
            } else {
                objects.remove(list.get(i));
            }
        }
        return objects.toArray(new String[objects.size()]);
    }
}
