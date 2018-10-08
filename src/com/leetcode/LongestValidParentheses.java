package com.leetcode;

import java.util.Stack;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/8 10:32
 */
/***
 * 题目来源： https://leetcode.com/problems/longest-valid-parentheses/description/
 * 时间复杂度 O(N) 空间复杂度 O(N)
 * 思路：利用栈的性质，栈中存储可能的有效串的左下标 ，
 * 解：先将-1压栈作为初始值，遍历字符串
 * 1- '(' 时，将当前的下标压栈
 * 2- ')' 时，先弹出栈顶元素 ，分为两种情况
 *         一、若此时栈为空 {说明多出了一个')'}，则之前已匹配的字符串不能与后续字符串组成更优的解
 *         二、若栈不为空 则可能还可以匹配更长的字符串，判断当前匹配的字符串长度是否比之前的更大
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int idx = 0;
        stack.push(-1);
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') {
                stack.push(idx);
            } else if (s.charAt(idx) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(idx);
                } else {
                   res =Math.max(res,idx-stack.peek());
                }
            }
            idx++;
        }

        return res;
    }

    public static void main(String[] args) {
//        String s = "(()";
//        String s = "((()";
        String s = "))(((())(())";
//        String s = "((())(())))";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(s));
    }
}
