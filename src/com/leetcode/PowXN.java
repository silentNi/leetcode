package com.leetcode;

import java.text.DecimalFormat;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/22 14:34
 */
/***
 * 题目来源： https://leetcode.com/problems/powx-n/description/
 * 时间复杂度 O(logn) 空间复杂度 O(1)
 * 思路：二分求解
 * 解：注意溢出 n == Integer.MIN_VALUE 时
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (x == -1) {
                return n % 2 == 0 ? 1 : -1;
            }
            if (n == Integer.MIN_VALUE) {
                n = Integer.MIN_VALUE + 1;
            }
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }


    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        double x = 2.0000;
        int n = 10;
        System.out.println(powXN.myPow(x, n));
    }
}
