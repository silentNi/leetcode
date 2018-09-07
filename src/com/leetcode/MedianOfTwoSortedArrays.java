package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/7 11:07
 */

/***
 * 题目来源： https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 时间复杂度 O(log(m+n))
 * 思路：将两个有序数组的中位数问题转化为求第K小数问题,利用中位数的性质。
 * 解：
 * 比较从给定下标开始的两个数组的位于第（k/2）个数
 * 如果 nums1[start1+k/2-1] < nums2[start2+k/2-1] ，
 * 那么 nums1从start1开始的前k/2个数都小于nums2[start2+k/2-1] 一定在中位数的左边 ，
 * 更新nums1的起始下标 start1 = start1 +k/2; 转化为求第(k-k/2)小数,缩小问题规模 ;
 * 反之亦然
 * 递归结束条件 ：其中一个数组的起始下标越界 或者 k==1 (即求第1小数)
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 所求的中位数 可以转化为 寻找第K小数问题
        int total = nums1.length + nums2.length;
        return (findKth(nums1, 0, nums2, 0, (total + 1) / 2) + findKth(nums1, 0, nums2, 0, (total + 2) / 2)) / 2;

    }
    /**
     * 寻找第K小数
     *
     * @param nums1
     * @param start1 nums1数组的起始下标
     * @param nums2
     * @param start2 nums2数组的起始下标
     * @param k      k>0 k=1,2,3……
     * @return
     */
    public double findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (nums1.length - 1 < start1) {
            return nums2[start2 + k - 1];
        }
        if (nums2.length - 1 < start2) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int nums1_mid =Integer.MAX_VALUE;
        int nums2_mid= Integer.MAX_VALUE;
        if(start1 + k / 2 - 1< nums1.length){
            nums1_mid = nums1[start1 + k / 2 - 1];
        }
        if(start2 + k / 2 - 1< nums2.length){
            nums2_mid = nums2[start2 + k / 2 - 1];
        }
        if (nums1_mid < nums2_mid) {
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        int[] num1={1,10};
        int[] num2={2,3,4,5,6,7,8,9};
        System.out.println(median.findMedianSortedArrays(num1,num2));
    }
}
