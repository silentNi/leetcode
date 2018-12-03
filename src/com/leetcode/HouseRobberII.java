package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/30 16:13
 */
/***
 * 题目来源： https://leetcode.com/problems/house-robber-ii/
 * 时间复杂度 O(N) 空间复杂度 O(1)
 * 思路：两次自底向上法
 * 解：house循环的连接的话 就两次自底向上法 一次 0 -> n-2 一次 1 -> n-1
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int max = 0;
        int lastMax =0;
        for(int i=0;i<nums.length-1;i++){
            int t= lastMax;
            lastMax =max;
            max=Math.max(max,t+nums[i]);
        }
        int max2 = 0;
        lastMax =0;
        for(int i=1;i<nums.length;i++){
            int t= lastMax;
            lastMax =max2;
            max2=Math.max(max2,t+nums[i]);
        }
        return Math.max(max,max2);
    }
    public static void main(String[] args){
//        int nums[] = {1,2,3,5};
        int nums[] = {1,2,3,1};
        HouseRobberII houseRobber= new HouseRobberII();
        System.out.println(houseRobber.rob(nums));
    }
}
