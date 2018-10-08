package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/8 9:24
 */
/***
 * 题目来源： https://leetcode.com/problems/next-permutation/
 * 时间复杂度 O(N)  where N=nums.length  空间复杂度 O(1)
 * { 最坏情况 如[4,5,3,2,1]
 * 找到idx需要O(N) 找到largeIdx需要O(N) 反转数组需要O(logN)
 * 共需要 O(N+N+logN) 但是时间复杂度还是O(N) 级别的 }
 * 思路：从后往前找，找到第一个比它后一位小的数记做x，此时x后的数都为降序排列，(.A..)x(.D..)  数组D↓降序
 * 再次从后往前找，找到第一个数比x大，记做y，交换x和y，此时数组由 (.A..)x(.B..)y(.C..) --> (.A..)y(.B..)x(.C..)
 * 数组(.B..)x(.C..) 还是降序 因为 (.B..)↓ >= x > (.C..)↓
 * 反转数组 (.B..)x(.C..) 此时得到的数组nums恰好为原nums数组的下一个恰好比它大的排列组合序列
 * 解： 见思路和代码
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 如 nums={ 4,1,5,3,2}
        // 从后往前遍历 找到第一个比其后一个数小的数的下标
        int idx = findSmallIdx(nums);
        if (idx == -1) {
            // 未找到比其后所有值小的数 ,即整个数组都是降序的 不存在下一个排列组合比它大 反转整个数组 找到最小的排列组合序列
            reverseArray(nums, 0, nums.length - 1);
            return;
        }
        // 找到比这个数大一点点的数的下标
        int largeIdx = findLargeIdx(nums, idx);
        // 交换这两个数  4,(1),5,3,(2) --> 4,(2),5,3,(1)
        swapArray(nums,idx,largeIdx);
        // 此时 idx下标后的数组为降序 4,2,(5,3,1)
        // 反转这个数之后的数组 得--> 4,2,(1,3,5)
        reverseArray(nums,idx+1,nums.length-1);

    }

    private int findLargeIdx(int[] nums, int idx) {
        int end = nums.length - 1;
        while (end > idx) {
            if (nums[end] > nums[idx]) {
                return end;
            }
            end--;
        }
        return -1;
    }

    private int findSmallIdx(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private void swapArray(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            swapArray(nums,start,end);
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        int[] nums={1,1,5};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        for(int i =0 ;i<nums.length;i++){
            System.out.print(nums[i]+ " ");
        }
    }
}
