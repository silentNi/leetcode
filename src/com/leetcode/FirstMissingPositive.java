package com.leetcode;

import java.util.Arrays;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/12 14:41
 */
/***
 * 题目来源： https://leetcode.com/problems/first-missing-positive/
 * 时间复杂度 O(N) N=nums.length 最坏时间复杂度O(3N)=排序O(2N)+查找O(N)  空间复杂度 O(1)
 * 思路：根据题意 将数组排序成 1...len(xxxx) x为负数或者大于nums.length的值 即下标为i的位置存放数i+1
 * 解：从idx=0开始，
 * 1. 找到nums[idx]>0 且 nums[idx]-1 (该数应该存放的位置) 不超过数组的索引 且 nums[nums[idx]-1]!=nums[idx] (过滤重复值,该数应该存放的位置上未正确赋值)
 * 从当前idx继续遍历
 * 2. 如果未找到 idx++
 *
 * 排序完成后从0下标开始,找到第一个不满足数值等于下标加一的下标
 */
public class FirstMissingPositive {
    /**
     * Your algorithm should run in O(n) time and uses constant extra space.
     * 找到nums数组中第一个丢失的正整数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] > 0 && nums[idx] - 1 < nums.length && nums[nums[idx] - 1] != nums[idx]) {
                swap(nums, idx, nums[idx] - 1);
            } else {
                idx++;
            }
        }
        idx = 0;
        while (idx < nums.length && nums[idx] == idx + 1) {
            idx++;
        }
        return idx+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 1, 2};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }
}
