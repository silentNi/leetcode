package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/12/3 14:08
 */
/***
 * 题目来源： https://leetcode.com/problems/edit-distance/
 * 时间复杂度 O(N*M) 空间复杂度 O(N*M) N=word1.length M=word2.length
 * 思路：自底向上法
 * 解：          i  (j==0) i次删除
 * dp[i][j] =    j  (i==0) j次插入
 *               max(dp[i-1][j-1],dp[i-1][j]+1,dp[i][j-1]+1)    X(i) =  Y(j) 不变，X增，Y增
 *               max(dp[i-1][j-1]+1,dp[i-1][j]+1,dp[i][j-1]+1)  X(i) ≠ Y(j) 替换，X增，Y增
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 || len2 == 0) {
            return len1 + len2;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 插入或增加
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 不变
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    // 替换
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance(s1, s2));
    }
}
