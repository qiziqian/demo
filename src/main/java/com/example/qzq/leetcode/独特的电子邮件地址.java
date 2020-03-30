package com.example.qzq.leetcode;

import java.util.HashSet;

/**
 * @Classname 独特的电子邮件地址
 * @Description
 * @Date 2019/10/7 20:26
 * @Created by qiziqian
 */
public class 独特的电子邮件地址 {
    public static void main(String[] args) {
        numUniqueEmails(new String[]{"leetcode.email+alex@leetcode.com", "leetcode.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"});
    }

    public static int numUniqueEmails(String[] emails) {
        HashSet set = new HashSet();
        for (int i = 0; i < emails.length; i++) {
            String s = emails[i].substring(0, emails[i].indexOf("@"));
            char[] chars = s.toCharArray();
            String name = "";
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 46) {
                    continue;
                }
                if (chars[j] == 43) {
                    break;
                }
                name += chars[j];
            }
            set.add(name + emails[i].substring(emails[i].indexOf("@")));
        }
        return set.size();
    }
}
