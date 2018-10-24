package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/23 17:37
 */
/***
 * 题目来源： https://leetcode.com/problems/maximum-subarray/
 * 时间复杂度 O(N) 空间复杂度 O(1)
 * 思路：DP求解
 * 解：遍历数组，局部最优解和全局最优解比较
 *
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int lastMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 局部最优
            lastMax = nums[i] + (lastMax > 0 ? lastMax : 0);
            // 当前最优
            max = Math.max(max,lastMax);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums ={-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-2, 1, 2, 3};
        System.out.println(maximumSubarray.maxSubArray(nums));
    }
}
