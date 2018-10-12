package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/12 10:29
 */
/***
 * 题目来源： https://leetcode.com/problems/combination-sum-ii/
 * 时间复杂度 不会求 TAT
 * 空间复杂度 不会求 TAT
 * 思路：递归求解
 * 解：构建递归函数 记录有序数组的起始位置start，剩余需要获取的值left ，以及当前列表now中已存储的解
 * 递归结束条件：1. left=0 此时now中数字的累加和正好为target ，得解 ，加入解的集合
 *               2. start == candidates.length ==> 下标越界 ，已经遍历完整个数组 ，无解
 * 若不满足递归结束条件，此时可能存在解
 * 从i=start开始遍历数组，只要candidates[i] <= left 就有可能构成解的一部分
 * 过滤掉可能的重复解 从当前坐标开始，从重复的第二个元素开始到重复的最后一个元素，都看做与重复的第一个元素等价
 * 加入当前解 ，left = left - candidates[i]， start = i +1 进入下一次递归
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> now = new ArrayList<>();
        helper(candidates, res, now, target, 0);
        return res;
    }

    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> now, int left, int start) {
        if (left == 0) {
            res.add(new ArrayList<>(now));
            return;
        }
        if (start == candidates.length) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] > left){
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            now.add(candidates[i]);
            helper(candidates, res, now, left - candidates[i], i + 1);
            now.remove(now.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] nums = {2, 2, 2, 2, 3, 3, 4};
        int target = 8;
        System.out.println(combinationSumII.combinationSum2(nums, target));
        System.out.println(combinationSumII.combinationSum2(nums, target).size());
    }
}
