package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/28 9:52
 */
/***
 * 题目来源： https://leetcode.com/problems/divide-two-integers/
 * 时间复杂度 O((logN)^2)
 * 思路：一步一步减 ，程序太耗时 ，利用 左移运算符加快减的效率（获取能减的最大值x*除数,跳跃连续对除数减x次的步骤）
 * 解：对于各种边界条件直接返回结果 ，不满足边界条件则开始计算
 * 对于被除数 m 和除数 n ,
 * 首先找到 最大的 x*n <= m
 * m = m- x*n; 被除数m减少x个除数n
 * 取整结果res =  res + x ; 结果增加x个能减次数
 * 循环上述步骤 知道 m < n；被除数小于除数 无法进行下一步 此时得解
 * 另：需要知道取整取余相关的数学知识 取整取余结果的符号判定依据
 * 取整 符号位由被除数和除数共同决定 同号为正 异号为负 相当于异或操作
 * 取余 符号位由被除数符号决定
 */
public class DivideTwoIntegers {
    /**
     * @param dividend
     * @param divisor
     * @return dividend / divisor
     */
    public int divide(int dividend, int divisor) {
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                // when the result is overflow
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == 0) {
            return 0;
        }
        /*
         取整 被除数和除数 同号为正 异号为负
         取余 符号位由被除数符号决定
        */
        int signdividend = dividend < 0 ? -1 : 1;
        int signdivisor = divisor < 0 ? -1 : 1;
        int sign = signdividend == signdivisor ? 1 : -1;
        // 被除数和除数符号相同 取整值为正 ；不相同 为负
        int res = 0;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        while (a >= b) {
            int count = 1;
            long divs = b;
            while (a >= (divs << 1)) {
                divs = divs << 1;
                count = count << 1;
            }
            res += count;
            a -= divs;
        }
        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        int m = Integer.MIN_VALUE;
//        int m = -5;
        int n = -1;
        System.out.println(m / n);
        System.out.println(m % n);
        System.out.println("-----");
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(m, n));
    }
}
