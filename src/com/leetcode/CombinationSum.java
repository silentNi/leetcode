package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/11 17:47
 */
/***
 * 题目来源： https://leetcode.com/problems/combination-sum
 * 时间复杂度 和target的大小和candidates数组的元素大小有关 O(#candidates^(target/min of candidates))
 * 空间复杂度 O(target/min of candidates))
 * 思路：递归求解
 * 解：构建递归函数 记录有序数组的起始位置start，剩余需要获取的值left ，以及当前列表now中已存储的解
 * 递归结束条件：1. left=0 此时now中数字的累加和正好为target ，得解 ，加入解的集合
 *               2. candidates[start] > left ==> 无解，从start开始最小的数都比left大则不存在解
 * 若不满足递归结束条件，此时可能存在解
 * 从start开始遍历数组，只要candidates[start] <= left 就有可能构成解的一部分
 * 加入当前解 ，left = left - candidates[start]，进入下一次递归
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);

        List<Integer> now = new ArrayList<>();
        helper(candidates, res, now, target,0);
        return res;
    }

    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> now, int left ,int start) {
        if (left == 0) {
            res.add(now);
            return;
        }
        if (candidates[start] > left) {
            return;
        }
        for (; start < candidates.length; start++) {
            if(candidates[start]<=left){
                List<Integer> newnow = new ArrayList<>(now);
                newnow.add(candidates[start]);
                helper(candidates,res,newnow,left-candidates[start],start);
            }else{
                break;
            }
        }
    }
    public static void main(String[] args){
        CombinationSum combinationSum = new CombinationSum();
        int[] nums={2,3,5};
        int target = 8;
        System.out.println(combinationSum.combinationSum(nums,target));
    }
}
