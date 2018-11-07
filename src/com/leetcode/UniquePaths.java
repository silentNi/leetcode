package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/7 9:24
 */
/***
 * 题目来源：https://leetcode.com/problems/unique-paths/
 * 时间复杂度 O(m*n) 空间复杂度 O(min(n,m))
 * 思路：DP求解 确定状态转移方程 DP[i] = DP[i] + DP[i-1]
 * 解：第i，j位置上的解是由 (i-1,j)和(i，j-1)位置上的解相加构成的，与其他位置无关
 * 所以只需要一个一维数组就可以存放需要用的解
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m < n) {
            return uniquePaths(n, m);
        }
        // m >= n 保证申请最小的空间
        int[] dp = new int[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i] + dp[i - 1];
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args){
        UniquePaths uniquePaths =new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,7));
    }
}
