package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/12 9:55
 */
/***
 * 题目来源： https://leetcode.com/problems/string-to-integer-atoi/description/
 * 时间复杂度 o(n)? 不是很好判断
 * 思路：遍历字符串 无特殊技巧
 * 解：遍历字符串遇到第一个不为 ' ' 的字符决定返回值的符号 若为'-'则跳过继续遍历 ；
 * 若为是数字的字符则记录结果并判断是否溢出，溢出则根据符号返回Integer.MAX_VALUE 还是 Integer.MIN_VALUE，继续遍历
 * 当遇到不是数字的字符则遍历结束
 */
public class StringToInteger {
    public int myAtoi(String str) {
        int res = 0;
        int sign = 1;
        boolean isFirst = true;
        boolean signFlag = true;
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (isFirst) {
                if (c[i] == ' ') {
                    continue;
                }
                isFirst = false;
            }
            if (signFlag) {
                signFlag = false;
                if (c[i] == '-') {
                    sign = -1;
                    continue;
                }
                if (c[i] == '+') {
                    continue;
                }
            }
            if ('0' <= c[i] && c[i] <= '9') {
                int n = c[i] - '0';
                int temp = res * 10 + n;
                if ((temp - n) / 10 != res || temp < 0) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = temp;
                continue;
            }
            break;
        }
        return res * sign;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
//        String s="   -32222222222222";
        String s = "-2147483648";
        System.out.println(stringToInteger.myAtoi(s));
    }
}
