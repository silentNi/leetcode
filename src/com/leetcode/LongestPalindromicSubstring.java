package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/7 11:18
 */

/***
 * 题目来源： https://leetcode.com/problems/longest-palindromic-substring/description/
 * 时间复杂度 O(n^2)
 * 思路：判断一个字符串s(i,j)是否为回文串，只需判断s(i+1,j-1)是否为回文串
 * 解：DP思路 dp[i][j]表示s(i,j)是否是回文串
 * 对所有可能的字符串s(i,j) j>=i进行判断
 * 如果dp[i][j]==true s(i,j)是回文串 j-i+1与 res的长度进行比较 如果更长则替换。
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                /**
                 * explain why j-i < 3
                 * j-i == 0, only a character is a palindrome,
                 * j-i == 1 and s.charAt(i) == s.charAt(j), ij is a palindrome,
                 * j-i == 2 and s.charAt(i) == s.charAt(j), no matter what between i and j, i#j is a palindrome
                 */
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && ( j - i + 1 > res.length())){
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring palindromic = new LongestPalindromicSubstring();
//        String s= "";
        String s= "abcsdscdwdfdf";
        System.out.println(palindromic.longestPalindrome(s));
    }
}
