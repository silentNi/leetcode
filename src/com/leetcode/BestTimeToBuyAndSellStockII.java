package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/23 16:53
 */

/***
 * 题目来源： https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 时间复杂度 O(N) 空间复杂度 O(1)
 * 思路：Greedy 贪心算法
 * 解：采用贪心策略 保证无后效性
 *  G(1) -->  G(2) -->  ... -->  G(n-1) -->  G(n)
 *  当前状态可以由前一个状态得出
 *  G(n) = G(n-1) + (prices[n] > prices[n - 1] ? prices[n] - prices[n - 1] : 0)
 */
public class BestTimeToBuyAndSellStockII {
    /**
     * 可以多次买卖
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String... args) {
        BestTimeToBuyAndSellStockII stock = new BestTimeToBuyAndSellStockII();
//        int[] nums ={7,1,5,3,7,4};
        int[] nums = {7, 6, 4, 3, 1};
        System.out.println(stock.maxProfit(nums));
    }
}
