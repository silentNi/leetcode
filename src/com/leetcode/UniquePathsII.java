package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/7 9:51
 */
/***
 * 题目来源：https://leetcode.com/problems/unique-paths-ii/
 * 时间复杂度 O(m*n) 空间复杂度 O(n)
 * 思路：DP求解 确定状态转移方程
 * 根据是否是障碍物划分
 * 1.不是障碍物 --> DP[i] = DP[i] + DP[i-1]
 * 2.是障碍物   --> DP[i] = 0
 * 解：第i，j位置上的解最多和 (i-1,j)和(i，j-1)位置上的解有关，与其他位置无关
 * 所以只需要一个一维数组就可以存放需要用的解
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        // 初始化
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        if (dp[0] == 0) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i - 1];
        }

        for (int row = 1; row < m; row++) {
            dp[0] = obstacleGrid[row][0] == 1 ? 0 : dp[0];
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[row][i] == 1) {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i] + dp[i - 1];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int[][] obs = {
                {0},
                {1},

        };
        System.out.println(uniquePathsII.uniquePathsWithObstacles(obs));
    }
}
