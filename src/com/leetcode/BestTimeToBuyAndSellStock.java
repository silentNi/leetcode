package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/23 16:36
 */
/***
 * 题目来源： https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 时间复杂度 O(N) 空间复杂度 O(1)
 * 思路：用两个变量分别记录买进的最小值和当前的最优解 每次遍历更新这两个值
 * 解：见代码
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int buy = prices[0];
        int profit =0;
        for(int  i= 1;i<prices.length;i++){
            profit = Math.max(profit,prices[i]-buy);
            buy = Math.min(buy,prices[i]);
        }
        return profit;
    }
    public static void main(String[] args){
        BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();
        int[] nums ={7,1,5,3,7,4};
        System.out.println(stock.maxProfit(nums));
    }
}
