package com.wangwei.leetcode.stack;

import java.util.Stack;

/**
 * @Author wangwei
 * @Date 2021/3/28 6:26 下午
 * @Version 1.0
 *  *
 *  * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *  *
 *  * 有效字符串需满足：
 *  *
 *  * 左括号必须用相同类型的右括号闭合。
 *  * 左括号必须以正确的顺序闭合。
 *  * 注意空字符串可被认为是有效字符串。
 */
public class Leetcode_20 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                Character topChar = stack.pop();
                if (c == '}' && topChar != '{')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == ')' && topChar != '(')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
