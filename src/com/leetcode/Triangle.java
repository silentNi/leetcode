package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/23 15:31
 */
/***
 * 题目来源： https://leetcode.com/problems/triangle/submissions/
 * 时间复杂度 O(N^2) 空间复杂度 O(N) N=triangle.size()
 * 思路：自底向上的动态规划
 * 解：opt[i] = Min(opt[i],opt[i+1])+value;
 * -> 最优子结构 用子问题的最优解来构造原问题的最优解
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] opt = new int[n + 2];
        for (int i = n; i >=1; i--) {
            for(int j=1;j<=i;j++){
                opt[j] = Math.min(opt[j],opt[j+1])+triangle.get(i-1).get(j-1);
            }
        }
        return opt[1];
    }
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(2));
        res.add(Arrays.asList(3,4));
        res.add(Arrays.asList(6,5,7));
        res.add(Arrays.asList(4,1,8,3));
        System.out.println(triangle.minimumTotal(res));
    }
}
