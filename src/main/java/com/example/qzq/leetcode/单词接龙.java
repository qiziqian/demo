package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName : 单词接龙
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-11-05 11:28
 */
public class 单词接龙 {
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(ladderLength("hit", "cog", list));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        dfs(beginWord, endWord, wordList, 0, new HashSet());
        return minTime;
    }

    public static void dfs(String beginWord, String endWord, List<String> wordList, int currTime, Set<String> set) {
        if (beginWord.equals(endWord)) minTime = Math.min(minTime, currTime);
        Set<String> currSet = new HashSet(set);

        for (String word : wordList) {
            if (currSet.contains(word)) continue;
            currSet.add(word);
            if (couldConvert(beginWord, word)) {
                dfs(word, endWord, wordList, currTime + 1, currSet);
            }
            currSet.remove(word);
        }

    }

    public static boolean couldConvert(String beginWord, String dictWord) {
        if (beginWord.length() != dictWord.length()) return false;
        int time = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != dictWord.charAt(i)) time++;
        }
        return time == 1;
    }

}