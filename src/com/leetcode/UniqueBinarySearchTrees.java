package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/22 14:15
 */

/***
 * 题目来源： https://leetcode.com/problems/unique-binary-search-trees/
 * 时间复杂度 O(N^2) 空间复杂度 O(N)
 * 思路：状态转移方程 f(n+1) = (i=0 --> i=n)∑ f(i)*f(n-i)
 * 解：f(n)与前面的所有状态都有关
 * 对于数1,2，...,n  选取一个数i作为根节点，根据二叉搜索树的特性，
 * 他的左子树由(1,2,...,i-1)构成
 * 他的右子树由(i+1,...,n)构成
 * 这样的时间复杂度其实已经很高达到了O(N^2)的级别，
 * 如果使用卡特兰数(http://lanqi.org/interests/10939/)的话，时间复杂度可以降到O(N)
 * */
public class UniqueBinarySearchTrees {
    /**
     * using Catalan to simply the time complex from O(n^2) to O(n)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        long res =1L;
        for (int i = 0; i < n; i++) {
            res = res*(4*i+2)/(i+2);
        }
        return (int)res;

    }

    /**
     * Given n, how many structurally unique BST's
     * (binary search trees) that store values 1 ... n?
     *
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = calculate(dp, i);
        }
        return dp[n];
    }

    private int calculate(int[] dp, int i) {
        int res = 0;
        for (int j = 1; j <= i; j++) {
            res += dp[j - 1] * dp[i - j];
        }
        return res;
    }

    public static void main(String... args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        for (int i = 0; i < 20; i++) {
            System.out.println(i + "-->" + uniqueBinarySearchTrees.numTrees(i));
        }
    }
}
