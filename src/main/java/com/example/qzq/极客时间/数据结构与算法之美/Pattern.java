package com.example.qzq.极客时间.数据结构与算法之美;

/**
 * @Classname Pattern
 * @Description 正则表达式尝试,* 匹配任意0个或者多个字符,?匹配0个或者1个字符
 * @Date 2019/11/18 14:30
 * @Created by qiziqian
 */
public class Pattern {
    private boolean matched;
    private char[] pattern;
    private int plen;

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = pattern.length;
    }

    public boolean match(char[] text, int len) {
        matched = false;
        rmatch(0, 0, text, len);
        return matched;
    }

    public void rmatch(int ti, int pj, char[] text, int tlen) {
        if (matched) return;
        if (pj == plen) {
            if (ti == tlen) matched = true;
            return;
        }
        if (pattern[pj] == '*') {
            for (int k = 0; k < tlen - ti; k++) {
                rmatch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') {
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) {
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }
}
