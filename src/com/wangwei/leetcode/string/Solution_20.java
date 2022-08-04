package com.wangwei.leetcode.string;


import java.util.Objects;
import java.util.Stack;

/**
 * @author wangwei
 * @version 1.0
 * @date 2022-08-02 14:26
 */
public class Solution_20 {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Objects.equals(c, '(') || Objects.equals(c, '[') || Objects.equals(c, '{')) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution_20 solution_20 = new Solution_20();
        //String str = "()[]{}";
        String str = "123";
        System.out.println(solution_20.isValid(str));
    }
}
