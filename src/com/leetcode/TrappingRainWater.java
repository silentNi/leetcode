package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/15 9:41
 */
/***
 * 题目来源： https://leetcode.com/problems/trapping-rain-water/
 * 时间复杂度 O(N) N=height.length 空间复杂度 O(1)
 * 思路：双指针遍历数组
 * 解：先找到左峰值和右峰值的下标， 左右峰值中间必定存在至少一个数比他俩小
 * 双指针遍历数组，
 * 1. left <= right; l指针往右走 同时记录当前的坑所积累的雨量
 * 2. left >  right; r指针往左走 同时记录当前的坑所积累的雨量
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        // 找到 l 使得 height[l] >= {height[0,i-1]} 左->右 升序的最高l
        while (l < r && height[l] <= height[l + 1]) {
            l++;
        }
        // 右->左 升序的最高r
        while (l < r && height[r - 1] >= height[r]) {
            r--;
        }
        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (left > right) {
                // 从右开始往左走 找到所有比right 小的值
                while (l < r && height[--r] < right) {
                    ans += right - height[r];
                }
            } else {
                // 从左开始往右走 找到所有比left 小的值
                while (l < r && height[++l] < left) {
                    ans += left - height[l];
                }
            }
        }
        return ans;
    }

    public int trap2(int[] height) {
        return solver(height, 0, height.length - 1, 1, 0);
    }

    /***
     * leetcode testcase都pass了但是超时了。sad TAT
     * @param height
     * @param start
     * @param end
     * @param deep
     * @param sum
     * @return
     */
    private int solver(int[] height, int start, int end, int deep, int sum) {
        if (end - start <= 1) {
            return sum;
        }
        // 下一层的开始结束位置
        int first = start;
        int second = start;
        boolean isfirst = true;
        // 计算本层可以接住的雨量
        int now = 0;
        // is ok to collect rain
        boolean okToCollect = false;
        // 可以收集雨滴的上一个下标
        int lastIdx = start;
        // 可以出现低
        boolean okToDown = false;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (height[i] >= deep) {
                min = Math.min(height[i], min);
                if (isfirst) {
                    first = i;
                    isfirst = false;
                } else {
                    second = i;
                }
                if (okToCollect) {
                    // okToCollect = true 可以收集雨滴
                    now += i - lastIdx - 1;
                    okToDown = true;
                    lastIdx = i;
                    okToCollect = false;
                } else {
                    // okToCollect = false 还不能收集雨滴
                    okToDown = true;
                    lastIdx = i;
                }
            } else {
                if (okToDown) {
                    okToCollect = true;
                }
            }
        }
        int time = min - deep + 1;
        return solver(height, first, second, deep + time, sum + now * time);
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater.trap(height));
        System.out.println(trappingRainWater.trap2(height));
    }
}
