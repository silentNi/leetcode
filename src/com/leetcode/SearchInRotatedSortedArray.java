package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/8 15:21
 */
/***
 * 题目来源： https://leetcode.com/problems/two-sum/description/
 * 时间复杂度 O(logN) 空间复杂度 O(1)
 * 思路：整个数组 至多只有一次下降 下降后之后的数不可能再比nums[0]大 不下降则这个数组为升序
 *         ↗↓
 *      ↗   ↓
 *    ↗     ↓
 *  ↗       ↓
 *  - - - - - - - - - - - - - - - -
 *           ↓    ↗
 *           ↓  ↗
 *           ↓↗
 *
 *
 * 解：
 *  若 nums[left] <= nums[mid] 则下降点必在右半段
 *      1.target∈ [nums[left] , nums[mid]) target如果存在必定在左半段
 *      2.target∉ [nums[left] , nums[mid])  target如果存在必定在右半段
 *  若 nums[left] >  nums[mid] 则下降点必在左半段
 *      1.target∈ (nums[mid] , nums[left]) target如果存在必定在右半段
 *      2.target∉ (nums[mid] , nums[left])  target如果存在必定在左半段
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                // 下降点必在右
                if (nums[left] <= target && target < nums[mid]) {
                    //左半段 且升序
                    right = mid - 1;
                } else {
                    // 右半段
                    left = mid + 1;
                }
            } else {
                // 下降点必在左
                if (nums[mid] < target && target < nums[left]) {
                    // 右半段 且升序
                    left = mid + 1;
                } else {
                    // 左半段
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0, 1, 2, 3};
//        int[] nums = {4,5,6,7,8,1,2,3};

        int target = 0;
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        for (int i = 0; i < 10; i++) {
            System.out.println(search.search(nums, i));
        }
    }
}
