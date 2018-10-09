package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/9 10:36
 */
/***
 * 题目来源： https://leetcode.com/problems/search-insert-position/
 * 时间复杂度 O(N) 空间复杂度 O(1)
 * 思路：时间复杂度可以降到 O(logN) 利用二分查找方法
 * 解：
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        for (int i=0 ;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }
}
