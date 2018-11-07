package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/7 10:19
 */
/***
 * 题目来源：https://leetcode.com/problems/minimum-path-sum/
 * 时间复杂度 O(m*n) 空间复杂度 O(n)
 * 思路：DP求解 确定状态转移方程 dp[i] = min(dp[i],dp[i-1]) + value
 * 解：第i，j位置上的解和 (i-1,j)和(i，j-1)位置上的解有关，与其他位置无关
 * 所以只需要一个一维数组就可以存放需要用的解
 */
public class MinimumPathSum {
    // dp[i] = min(dp[i],dp[i-1]) + value
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 初始化
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int row = 1; row < m; row++) {
            dp[0] = dp[0] + grid[row][0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.min(dp[i], dp[i - 1]) + grid[row][i];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        System.out.println(minimumPathSum.minPathSum(grid));
    }
}
