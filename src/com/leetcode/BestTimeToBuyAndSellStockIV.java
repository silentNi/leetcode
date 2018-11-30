package com.leetcode;

import java.util.*;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/27 11:13
 */
/***
 * 题目来源： https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 时间复杂度 O(N*k) 空间复杂度 O(N*k)
 * 思路：自底向上法
 * 解：见代码
 */
public class BestTimeToBuyAndSellStockIV {
    // 自底向上法 可能更能够理解最优解的结构特征

    /**
     * /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */
    public int maxProfit(int k, int[] prices){
        int len = prices.length;
        if(k >= len/2){
            return greedySolution(prices);
        }
        int[][] dp = new int[k+1][len];
        for(int i=1;i<=k;i++){
            int pastBuy = -prices[0];
            for(int j=1;j<len;j++){
                dp[i][j]= Math.max(dp[i][j-1],pastBuy+prices[j]);
                pastBuy = Math.max(pastBuy,dp[i-1][j-1]-prices[j]);
            }
        }
        return dp[k][len-1];
    }

    //贪心解法
    private int greedySolution(int[] prices) {
        int profit =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }

    // 带备忘的自顶向下法 优势-相对于自底向上法 只计算必须的部分
    public int maxProfit1(int k, int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[prices.length + 1][k + 1];
        for (int i = 0; i <= prices.length ; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        return maxKProfit(dp, prices, prices.length, k);
    }

    /**
     * dp[n][k] present the max profit at price(0,...,n-1) with most k-th transation
     *
     * @param dp
     * @param prices
     * @param n
     * @param k
     * @return
     */
    private int maxKProfit(int[][] dp, int[] prices, int n, int k) {
        if (dp[n][k] != -1) {
            return dp[n][k];
        }
        if (n <= 1) {
            dp[n][k] = 0;
            return dp[n][k];
        }
        if (k == 0) {
            dp[n][k] = 0;
            return dp[n][k];
        }
        // 求解 dp[n][k]
        dp[n][k] = 0;
        if(2*k>=n){
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            dp[n][k] = profit;
        }else{
            for(int i =n-2;i>=0;i--){
                if(prices[i]<prices[n-1]){
                    while(i>=1&&prices[i-1]<prices[i]){
                        i--;
                    }
                    dp[n][k] = Math.max(dp[n][k],prices[n-1]-prices[i]+maxKProfit(dp,prices,i,k-1));
                }else{
                    while(i>=1&&prices[i-1]>prices[i]){
                        i--;
                    }
                    dp[n][k] = Math.max(dp[n][k],maxKProfit(dp,prices,i+1,k));
                }
            }
        }

        return dp[n][k];
    }

//    private int solver(int[] dp, int k, int[] prices, int n) {
//        if (dp[n] != -1) {
//            return dp[n];
//        }
//        if (n < 2) {
//            dp[n] = 0;
//            return 0;
//        }
//        if (k == 0) {
//            return 0;
//        }
//        // FIXME
//        int high = prices[n - 1];
//        int low = high;
//        int i = n - 2;
//        while (i >= 0 && prices[i] < high) {
//            low = prices[i];
//            i--;
//        }
//        if (i < 0) {
//            dp[n] = high - low;
//            return dp[n];
//        } else {
//            dp[n] = high - low + solver(dp, k - 1, prices, i + 1);
//            for (int j = i; j >= 0; j--) {
//                if (prices[j] < low) {
//                    dp[n] = Math.max(dp[n], )
//                }
//            }
//        }
//    }

    /***
     * 一种思路 一次遍历 ，将所有交易的收益值记录下来 取前K个最大的
     * 某些情况不行
     * @param k = 2
     * @param prices = [1,2,4,2,5,7,2,4,9,0]
     * @return expected = 13 but output = 12
     */
    public int maxProfit2(int k, int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int low = prices[0];
        int high = prices[0];
        boolean ready = false;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                high = prices[i];
                ready = true;
            } else {
                // prices[i] < prices[i-1]
                if (ready) {
                    list.add(high - low);
                    ready = false;
                }
                low = prices[i];
                high = low;
                // attach here  ready must be false;
            }

        }
        if (high > low) {
            list.add(high - low);
        }
        int res = 0;

        if (list.size() >= k) {
            list.sort((a, b) -> {
                return b - a;
            });
            int i = 0;
            while (i < k) {
                res += list.get(i);
                i++;
            }
        } else {
            res = list.stream().mapToInt(Integer::intValue).sum();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,2,5,7,2,4,9,0};
        int k = 2;
        BestTimeToBuyAndSellStockIV sellStockIV = new BestTimeToBuyAndSellStockIV();
        System.out.println(sellStockIV.maxProfit(k, nums));
    }
}
