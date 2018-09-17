package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/17 10:03
 */

/***
 * 题目来源： https://leetcode.com/problems/container-with-most-water/description/
 * 时间复杂度 o(n)
 * 思路：头尾往中间遍历 (不要思维固化，只知道从头到尾遍历）
 * 解：循环开始后，res 首先为 最大的end-start 乘以 min（高度），
 * 之后的面积若想比res大必须满足 min（高度）> 之前的最小高度 才有可能
 * 分为两种情况
 * 1.--> h=height[start] ( or h=height[end] )
 *       此时start++ 直到找到 height[start] > h
 *       eg.  [7,14,5,4,1,8]
 *       (14, 8)  可能比（7，8）大，因为（end-start）↓ 但是 min（高度）↑
 * 2.--> h=height[start]=h=height[end]
 *       此时 若是只是 start++ 直到找到 height[start] > h 所求得面积必然小于 res，
 *       所以必须 end-- 直到找到 height[end] > h 才有可能
 *       eg.  [8,20,5,4,15,8]
 *       (20, 8)   必然比（8，8）小 ,因为（end-start）↓ 而   min（高度）不变
 *       (20, 15)  可能比（8，8）大，因为（end-start）↓ 但是 min（高度）↑
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = -1;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int h = Math.min(height[start], height[end]);
            int temp = h * (end - start);
            res = temp > res ? temp : res;
            while (height[start] <= h && start < end) {
                start++;
            }
            while (height[end] <= h && start < end) {
                end--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();
//        int[] height = {1, 2, 3, 4, 5};
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(container.maxArea(height));
    }
}
