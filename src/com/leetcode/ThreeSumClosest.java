package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/21 9:49
 */
/***
 * 题目来源： https://leetcode.com/problems/3sum-closest/
 * 时间复杂度 o(n^2)
 * 思路：找出所有可能的sum 进行判断
 * 解：对数组进行排序 ，遍历数组 i-- >[0,nums.lenth-3]
 * 对每一种可能计算其和sum
 * 1-- > sum ==target  直接返回target
 * 2-- > sum < target  start++ 使得sum↑ 更接近target
 * 3-- > sum > target  end--   使得sum↓ 更接近target
 * 对每一个sum 如果其与target的距离小于res与target距离则 res=sum
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        long res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                // 防止溢出 [0，1，Integer.MaxValue]
                long sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                }else{
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return (int)res;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums= {-1,2,1,-4};
//        int[] nums = {1, 2, 5, 10, 11};
        int target = 1;
        System.out.println(threeSumClosest.threeSumClosest(nums, target));

    }
}
