package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/17 9:57
 */
/***
 * 题目来源： https://leetcode.com/problems/jump-game-ii/
 * 时间复杂度 O(N) N=nums.length 空间复杂度 O(1)
 * 思路：计算每一步的最近（上一次最远+1）和最远距离
 * 解：见代码
 */
public class JumpGameII {
    public int jump(int[] nums) {
        // 每一步都有一个对应的start和end下标 ,far为<start->end>最远可达的位置
        /*
         * 如 nums ={2，3，1，1，4}
         *    step = 0, 1, 1, 2, 2
         * step=0 时 start=0，end=0
         * step=1 时 start=1，end=2
         * step=2 时 start=3，end=4
         */
        int step = 0, start = 0, end = 0, far = 0;
        while (end < nums.length - 1 ) {
            step++;
            for (int i = start; i <= end; i++) {
                if (nums[i] + i > far) {
                    far = nums[i] + i;
                }
            }
            start = end + 1;
            end = far;
        }
        return step;
    }

    public int jump2(int[] nums) {
        int step = 0;
        // 当前最远可达
        int maxIdx = 0;
        // 下一次最远可达
        int nextMaxIdx = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMaxIdx = Math.max(nextMaxIdx, nums[i] + i);
            if (i == maxIdx) {
                step++;
                maxIdx = nextMaxIdx;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jumpGameII.jump(nums));
    }
}
