package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/18 10:22
 */
/***
 * 题目来源： https://leetcode.com/problems/permutations-ii/
 * 时间复杂度 O(N^2) 空间复杂度 最多O(N!)
 * 思路：递归回溯解决全排列，注意过滤重复解
 * 解：用Visited数组记录访问过的元素，只要元素未被访问过就将其放进now列表，回溯回来访问下个元素需要过滤重复值
 * 直到now列表的大小为nums.length的大小，此时得解；
 * 回溯，将最后一个加入now列表的数移除并将visited数组中对应的位置置为未访问，继续寻找下一个未访问过且不重复的数
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        uniqueSolver(res, nums, 0, now, visited);
        return res;
    }

    private void uniqueSolver(List<List<Integer>> res, int[] nums, int start, List<Integer> now, boolean[] visited) {
        if (now.size() == nums.length) {
            res.add(new ArrayList<>(now));
            return;
        }
        for (int i = start; i < start + nums.length; i++) {
            int real = i % nums.length;
            if (!visited[real]) {
                // 避免重复解 跳过重复元素 如 {1，1，2} 跳过第二个1 skip=1
                int skip = 0;
                int temp = real;
                while (temp < nums.length - 1 && nums[temp] == nums[temp + 1]) {
                    temp++;
                    skip++;
                }
                now.add(nums[real]);
                visited[real] = true;
                uniqueSolver(res, nums, real + 1, now, visited);
                visited[real] = false;
                now.remove(now.size() - 1);
                i = i + skip;
                // 最后for循环还有一个 i++
            }
        }
    }
    public static void main(String[] args){
        PermutationsII permutationsII = new PermutationsII();
        int[] nums ={3,1,1,1,2,2};
        System.out.println(permutationsII.permuteUnique(nums));
        System.out.println(permutationsII.permuteUnique(nums).size());
    }
}
