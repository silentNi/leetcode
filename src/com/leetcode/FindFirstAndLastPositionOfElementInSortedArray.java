package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/9 9:15
 */
/***
 * 题目来源： https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * 时间复杂度 O(logN) 空间复杂度 O(1)
 * 思路：利用两次折半查找实现O(2logN)时间复杂度的查找
 * 解： 先折半查找最左的匹配，判断是否能找到，不能找到则最右的匹配必定不能找到，直接返回；若能找到则寻找最右的匹配;
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        if (result[0] == -1) {
            return new int[]{-1, -1};
        }
        result[1] = findLast(nums, target);
        return result;
    }

    private int findLast(int[] nums, int target) {
        if (target < nums[0] || nums[nums.length - 1] < target) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                // 右半段
                low = mid + 1;
            } else if (nums[mid] > target) {
                // 左半段
                high = mid - 1;
            } else {
                // 中间值 = 目标值 判断是否可能向右延伸
                if (mid == high || nums[mid + 1] != target) {
                    return mid;
                } else {
                    // nums[mid+1]==target
                    // 可向右延伸
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    private int findFirst(int[] nums, int target) {
        if (target < nums[0] || nums[nums.length - 1] < target) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                // 右半段
                low = mid + 1;
            } else if (nums[mid] > target) {
                // 左半段
                high = mid - 1;
            } else {
                // 中间值 = 目标值 判断是否可能向左延伸
                if (mid == low || nums[mid - 1] != target) {
                    return mid;
                } else {
                    // nums[mid-1]==target
                    // 可向左延伸
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6};
//        int target = 6;
        int[] nums = {};
        int target = 0;
        FindFirstAndLastPositionOfElementInSortedArray find = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] res = find.searchRange(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
