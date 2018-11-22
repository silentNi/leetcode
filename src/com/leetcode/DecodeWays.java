package com.leetcode;

import java.util.Random;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/20 16:35
 */

/***
 * 题目来源： https://leetcode.com/problems/decode-ways/
 * 时间复杂度 O(N) N= s.length() 空间复杂度 O(1)
 * 思路：dp[i-1] and dp[i-2] --> dp[i] 分析当前状态可以由前两个状态得到
 * 解：状态转移方程 dp[i] = (condition1 ? dp[i-1]:0)+ (condition2 ? dp[i-2]:0)
 * 满足condition1则可以由dp[i-1]组合上s.subString(i-1,i)得到
 * 满足condition2则可以由dp[i-2]组合上s.subString(i-2,i)得到
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int one = 1;
        int two = 1;
        for (int i = 0; i < s.length(); i++) {
            int tmp = 0;
            // condition1
            if (s.charAt(i) != '0') {
                tmp += one;
            }
            // condition2
            if (i > 0 && (s.charAt(i - 1) == '1'
                    || (s.charAt(i - 1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6'))) {
                tmp += two;
            }
            two = one;
            one = tmp;
        }
        return one;
    }

    public int numDecodings2(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == '0') {
                // 00 - 09
                return 0;
            }
            if (s.charAt(1) == '0') {
                // 10 20 --> 1  ; 30 40 50 60 70 80 90 --> 0
                return s.charAt(0) < '3' ? 1 : 0;
            }
            if (s.charAt(0) == '1') {
                // 11-19
                return 2;
            }
            if (s.charAt(0) == '2') {
                //21-26 --> 2  ; 27-29 --> 1
                return s.charAt(1) < '7' ? 2 : 1;
            }
            return 1;
        }

        int[] dp = new int[s.length() + 1];
        dp[1] = numDecodings(s.substring(0, 1));
        dp[2] = numDecodings(s.substring(0, 2));
        int num;
        for (int i = 3; i <= s.length(); i++) {
            num = Integer.valueOf(s.substring(i - 2, i));
            dp[i] = dp[i - 2] * ((num > 9 && num < 27) ? 1 : 0) + dp[i - 1] * numDecodings(s.substring(i - 1, i));
        }
        return dp[s.length()];

    }

    private int solver(String s, int n, int[] ans) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return Integer.valueOf(s.substring(0, 1)) == 0 ? 0 : 1;
        }
//        if (n == 2) {
//            int num = Integer.valueOf(s.substring(0, 2));
//            return num > 26 ? 1 : 2;
//        }
        if (ans[n] != 0) {
            return ans[n];
        }

        int num2 = Integer.valueOf(s.substring(n - 2, n));
        int num1 = Integer.valueOf(s.substring(n - 1, n));
        ans[n] = ((num2 <= 26 && num2 >= 10) ? solver(s, n - 2, ans) : 0) + (num1 == 0 ? 0 : solver(s, n - 1, ans));
        return ans[n];
    }

    public static void main(String... args) {
        DecodeWays decodeWays = new DecodeWays();
//        Random random = new Random();
//        for(int i=1;i<10;i++){
//            long num = Math.abs(random.nextLong());
//            System.out.println(num+" --> " +decodeWays.numDecodings(String.valueOf(num)));
//        }
        String s = "2226";
        System.out.println(s + " --> " + decodeWays.numDecodings(s));
    }
}
