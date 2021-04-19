package com.wangwei.leetcode.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author wangwei
 * @Date 2021/3/5 下午7:51
 * @Version 1.0
 *  * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *  *
 *  * 有效字符串需满足：
 *  *
 *  * 左括号必须用相同类型的右括号闭合。
 *  * 左括号必须以正确的顺序闭合。
 *  * 注意空字符串可被认为是有效字符串。
 */
public class Solution_20 {
    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (Objects.equals(c, '(') || Objects.equals(c, '{') || Objects.equals(c, ']')){
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '('){
                    return false;
                }if (c == ']' && pop != '['){
                    return false;
                }if (c == '}' && pop != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[{]}"));
    }
}
