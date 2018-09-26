package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/26 11:13
 */
/***
 * 题目来源： https://leetcode.com/problems/generate-parentheses/
 * 时间复杂度 O({4^n}/sqrt{n})
 * 思路：递归思想，缩小问题规模
 * 解：在当前chars中，必须保证left>=right --> n >= sum( '(' ) >= sum( ')' )
 * 当left+right==2*n时(此时left==right==n)，此时的chars为一解
 * 当 left ==right时 此时只能添加'('
 * 当 left > right时 即可添加'('也可添加')'
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] chars = new char[2 * n];
        helper(res, chars, 0, 0, n);
        return res;
    }

    private void helper(List<String> res, char[] chars, int left, int right, int n) {
        if (left > n || right > n) {
            return;
        }
        if (left + right == 2 * n) {
            res.add(String.valueOf(chars));
            return;
        }
        if (left == right) {
            chars[left + right] = '(';
            helper(res, chars, left + 1, right, n);
        } else if (left > right) {
            chars[left + right] = '(';
            helper(res, chars, left + 1, right, n);
            chars[left + right] = ')';
            helper(res, chars, left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        int n = 4;
        System.out.println(generateParentheses.generateParenthesis(n));
    }
}
