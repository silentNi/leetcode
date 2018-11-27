package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/27 10:14
 */
/***
 * 题目来源： https://leetcode.com/problems/maximum-product-subarray/
 * 时间复杂度 O(N) 空间复杂度 O(1)
 * 思路：自底向上法
 *               |-   nums[0] (n==0)
 * 解：Pmax(n)= -|
 *               |-   max( nums[n], Pmax(n-1)*nums[n], Pmin(n-1)*nums[n] ) (n>=1)
 *
 * 原问题的解 可以由 子问题的最优解得到
 * maxProduct = max(∑(i=0-->i=n-1)P(i))
 */
public class MaximumProductSubarray {
    /**
     * 连续子数组的最大乘积
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mayMax = max * nums[i];
            int mayMin = min * nums[i];
            // 以nums[i]结尾的最大值
            max = Math.max(nums[i], mayMax > mayMin ? mayMax : mayMin);
            // 以nums[i]结尾的最小值
            min = Math.min(nums[i], mayMax > mayMin ? mayMin : mayMax);
            res = Math.max(res,max);
        }
        return res;
    }
    public static void main(String[] args){
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] nums={-2,0,-1};
        System.out.println(maximumProductSubarray.maxProduct(nums));
    }
}
