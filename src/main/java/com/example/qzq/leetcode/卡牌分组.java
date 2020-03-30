package com.example.qzq.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname 卡牌分组
 * @Description
 * @Date 2019/10/10 9:46
 * @Created by qiziqian
 */
public class 卡牌分组 {
    public static void main(String[] args) {

        hasGroupsSizeX2(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
    }

    public static boolean hasGroupsSizeX2(int[] deck) {
        List<Integer> collect = Arrays.stream(deck).distinct().sorted().mapToObj(i -> i).collect(Collectors.toList());
        int[] count = new int[collect.size()];

        for (int i = 0; i < deck.length; i++) {
            count[collect.indexOf(deck[i])]++;
        }

        int max = Arrays.stream(count).max().getAsInt();

        while (max >= 2) {
            final int x = max;
            if (Arrays.stream(count).allMatch(i -> i % x == 0)) {
                return true;
            }
            max--;
        }
        return false;
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < deck.length; i++) {
            if (!map.containsKey(deck[i])) {
                map.put(deck[i], 1);
            } else {
                map.put(deck[i], map.get(deck[i]) + 1);
                max = max > map.get(deck[i]) ? max : map.get(deck[i]);
            }
        }

        while (max > 1) {
            int num = map.size();
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getValue() % max != 0) {
                    break;
                }
                num--;
            }
            if (num == 0) return true;
            max--;
        }
        return false;
    }

    public boolean hasGroupsSizeX4(int[] deck) {
        int[] count = new int[10000];
        for (int c : deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    public boolean hasGroupsSizeX3(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c : deck)
            count[c]++;

        List<Integer> values = new ArrayList();
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0)
                values.add(count[i]);

        search:
        for (int X = 2; X <= N; ++X)
            if (N % X == 0) {
                for (int v : values)
                    if (v % X != 0)
                        continue search;
                return true;
            }

        return false;
    }
}
