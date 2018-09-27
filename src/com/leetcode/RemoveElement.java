package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/27 15:14
 */
/***
 * 题目来源： https://leetcode.com/problems/remove-element/
 * 时间复杂度 o(n)
 * 思路：一次遍历，是指定值则跳过，不是指定值则覆盖写
 * 解：同思路，见代码一看就会。
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
    public static void main(String[] args){
//        int[] nums ={3,2,2,3};
        int[] nums ={2,2};
//        int[] nums ={0,1,2,2,3,0,4,2};
        int val =2;
        RemoveElement removeElement = new RemoveElement();
        int len = removeElement.removeElement(nums,val);
        System.out.println("len:"+len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
