package com.leetcode;

import java.util.stream.IntStream;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/20 15:44
 */

/***
 * 题目来源： https://leetcode.com/problems/climbing-stairs/
 * 时间复杂度 O(n) 空间复杂度 O(1)
 * 思路：状态转移方程 : f(n) = f(n-1) + f(n-2)
 * 解：
 */
public class ClimbingStairs {
    // 斐波那切数列 求解
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = second;
            second += first;
            first = temp;
        }
        return second;
    }

    // DP solution
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] ans = new int[n + 1];
        ans[1] = 1;
        ans[2] = 2;
        return solver(ans, n);
    }

    private int solver(int[] ans, int n) {
        if (ans[n] == 0) {
            ans[n - 1] = solver(ans, n - 1);
            ans[n - 2] = solver(ans, n - 2);
            return ans[n - 1] + ans[n - 2];
        }
        return ans[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        IntStream.iterate(1, i -> (i + 1)).limit(20).peek(o -> {
            System.out.println(climbingStairs.climbStairs(o));
        }).sum();
//        System.out.println(climbingStairs.climbStairs(1));

    }
}
