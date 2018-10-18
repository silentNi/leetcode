package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/18 9:32
 */
/***
 * 题目来源： https://leetcode.com/problems/permutations/
 * 时间复杂度 O(N^2) N=nums.length  空间复杂度 O(N!)
 * 思路：递归回溯解决全排列
 * 解：用Visited数组记录访问过的元素，只要元素未被访问过就将其放进now列表，
 * 直到now列表的大小为nums.length的大小，此时得解；
 * 回溯，将最后一个加入now列表的数移除并将visited数组中对应的位置置为未访问，继续寻找下一个未访问过的数
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solver(res, nums, 0, now ,visited);
        return res;
    }

    private void solver(List<List<Integer>> res, int[] nums, int start, List<Integer> now, boolean[] visited) {
        if (now.size() == nums.length) {
            res.add(new ArrayList<>(now));
            return;
        }
        for (int i = start; i < start + nums.length; i++) {
            int real = i % nums.length;
            if(!visited[real]){
                now.add(nums[real]);
                visited[real]=true;
                solver(res,nums,real+1,now,visited);
                visited[real]=false;
                now.remove(now.size()-1);
            }
        }
    }
    public static void main(String[] args){
        Permutations permutations = new Permutations();
        int[] nums ={1,2,3,4,5};
        System.out.println(permutations.permute(nums));
        System.out.println(permutations.permute(nums).size());
    }
}
