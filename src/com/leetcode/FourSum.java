package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/25 10:44
 */
/***
 * 题目来源： https://leetcode.com/problems/4sum/
 * 时间复杂度 o(n^3)
 * 思路：两头向中间逼近
 * 解：假设给定 i，j --> 使得 i < start < end < j
 * nums[i]+nums[j] 固定 ,即求 start 和 end 使得  nums[start] + nums[end] == target - nums[i] - nums[j]
 * 此后解法与ThreeSum相同
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            //  过滤重复值 如[-2,-2,-1,0,1,2]
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; j > i + 2; j--) {
                //  过滤重复值 如[-2,-1,0,1,2,2]
                if (j != nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int start = i + 1;
                int end = j - 1;
                // 所求的内部两数之和 i < start < end < j
                int sum = target - nums[i] - nums[j];
                while (start < end) {
                    if (nums[start] + nums[end] == sum) {
                        List<Integer> list = Arrays.asList(nums[i], nums[start], nums[end], nums[j]);
                        res.add(list);
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] < sum) {
                        start++;
                    } else {
                        end--;
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, 0, 1, 0,-1,-1, -2, 2,2, 2, 2,-6};
        int target = 0;
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(nums, target));
    }
}
