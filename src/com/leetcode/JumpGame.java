package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/17 9:32
 */
/***
 * 题目来源： https://leetcode.com/problems/jump-game/
 * 时间复杂度 O(N) 最好O(1)最坏O(N) N=nums.length 空间复杂度 O(1)
 * 思路：每次计算当前位置最远可到达的下标，只要下标大于等于数组的最大下标就认为可达
 * 解：从0下标开始，更新可达的最远下标，（下标<=最远可大下标）
 * 判断是否能达数组最后一个元素，可达结束循环，不可达继续计算下个坐标。
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        // 下标
        int i = 0;
        // 最远可大下标
        int maxIdx = 0;
        while(i<= maxIdx){
            maxIdx = Math.max(maxIdx,i + nums[i]);
            if(maxIdx >= nums.length-1){
                return true;
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args){
        JumpGame jumpGame =new JumpGame();
        int[] nums ={3,2,1,0,4};
        System.out.println(jumpGame.canJump(nums));
    }
}
