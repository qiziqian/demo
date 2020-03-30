package com.example.qzq.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Classname 有效的括号
 * @Description
 * @Date 2019/10/24 15:34
 * @Created by qiziqian
 */
public class 有效的括号 {
    //  [{}()({})}]
    public static void main(String[] args) {
//        System.out.println((int)'[');
//        System.out.println((int)']');
//        System.out.println((int)'{');
//        System.out.println((int)'}');
        System.out.println((int) '(');
        System.out.println((int) ')');
        System.out.println(')' - '(');
        System.out.println(isValid("()[]{}"));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
                if (stack.empty()) return false;
                Character pop = stack.pop();
                if (s.charAt(i) - pop != 2 & s.charAt(i) - pop != 1) return false;
            }
        }
        return stack.empty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
                if (stack.empty()) return false;
                Character pop = stack.pop();
                if (map.get(pop) != s.charAt(i)) return false;
            }
        }
        return stack.empty();
    }
}
