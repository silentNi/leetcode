package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/30 15:30
 */
/***
 * 题目来源： https://leetcode.com/problems/house-robber/
 * 时间复杂度 O(N) 空间复杂度 O(1)
 * 思路：自底向上法
 * 解：对于每一个房间只有两种情况 抢或不抢
 * 1.抢  --> dp[i] = dp[i-2] + nums[i]
 * 2.不抢--> dp[i] = dp[i-1]
 * dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i])  (i>=2)
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int max = 0;
        int lastMax = 0;
        int t;
        for(int num:nums){
            t = lastMax;
            lastMax =max;

            max = Math.max(max,t+num);
        }
        return max;
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0],nums[1]);
//        for(int i=2;i<nums.length;i++){
//            // 抢或不抢的最大收益
//            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
//        }
//        return dp[nums.length-1];
    }
    public static void main(String[] args){
//        int nums[] = {1,2,3,5};
        int nums[] = {7,5,3,2};
        HouseRobber houseRobber= new HouseRobber();
        System.out.println(houseRobber.rob(nums));
    }
}
