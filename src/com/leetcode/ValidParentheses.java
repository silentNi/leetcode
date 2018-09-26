package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/26 9:36
 */
/***
 * 题目来源： https://leetcode.com/problems/valid-parentheses/
 * 时间复杂度 O(n)
 * 思路：利用Stack的性质 先进后出
 * 解：对s的每一个字符进行遍历
 *  1-开括号 --> 压入栈
 *  2-闭括号 --> 与栈顶元素进行判断
 *      若能匹配 则将栈顶元素弹出 继续遍历
 *      否则闭括号无法匹配即也无法被消除 invalid
 *  遍历完成后 stack为空则 valid ，非空则 invalid
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            // s长度为奇数时不可能为true
            return false;
        }
        Map<Character, Character> map = new HashMap<>(5);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 0 && map.containsKey(s.charAt(i))) {
                if (!stack.pop().equals(map.get(s.charAt(i)))) {
                    // 后半括号有不匹配的情况
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp= new ValidParentheses();
        String s="[[)()([{}])]";
        System.out.println(vp.isValid(s));
    }
}
