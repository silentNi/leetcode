package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/27 14:35
 */
/***
 * 题目来源： https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 时间复杂度 o(n)
 * 思路：一次遍历，重复值则跳过，不重复则覆盖写
 * 解：同思路，见代码一看就会。
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
    public static void main(String[] args){
//        int[] nums ={0,0,1,1,1,2,2,3,3,4};
        int[] nums ={1,1,2};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int len = removeDuplicatesFromSortedArray.removeDuplicates(nums);
        System.out.println("len:"+len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
