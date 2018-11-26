package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/26 9:49
 */
/***
 * 题目来源： https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 时间复杂度 O(N) 空间复杂度 O(1)
 * 思路：用四个变量分别记录第一、二次买进和第一、二次卖出时的收益
 * 解：三种解法，逐渐地将时间复杂度从一开始的O(N^2)降低到O(N)
 */
public class BestTimeToBuyAndSellStockIII {
    /**
     * 最快的解法 O(N) 一次遍历
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int sell1=0, sell2 = 0; // 卖出后的收益
        int buy1= Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE; // 买进后的收益
        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2,sell1-price);
            sell1 = Math.max(sell1,buy1+price);
            buy1= Math.max(buy1,-price);
        }
        return sell2;

    }

    /**
     * solution 1
     * 分成两次交易对第一次交易进行简化 最坏 O(N^2) 最好 O(N)
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > buy) {
                profit = Math.max(profit, prices[i] - buy + onceMaxProfit(prices, i + 1, prices.length - 1));
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }

    /**
     * solution 2
     * 最多两次交易 分解为两个最多一次交易 时间复杂度O(N^2)
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, onceMaxProfit(prices, 0, i) + onceMaxProfit(prices, i + 1, prices.length - 1));
        }
        return profit;
    }

    private int onceMaxProfit(int[] prices, int start, int end) {
        if (end - start < 1) {
            return 0;
        }
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (prices[i] > buy) {
                profit = Math.max(profit, prices[i] - buy);
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }

    public static void main(String... args) {
        BestTimeToBuyAndSellStockIII stockIII = new BestTimeToBuyAndSellStockIII();
        int[] nums = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] nums={1,2,3,4,5};
//        int[] nums = {7, 6, 4, 3, 1};
        System.out.println(stockIII.maxProfit(nums));
    }
}
