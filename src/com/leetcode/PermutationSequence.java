package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/6 9:51
 */
/***
 * 题目来源： https://leetcode.com/problems/permutation-sequence/
 * 时间复杂度 O(N) 空间复杂度 O(N)
 * 思路：对于k每次至少确定一个位置上的数，满足特殊条件时，解就确定了。
 * 解：对于第i(1<=i<=n)个位置上的数 比较 k 与(n - i)!的大小
 */
public class PermutationSequence {
    /**
     * @param n Given n will be between 1 and 9 inclusive.
     * @param k Given k will be between 1 and n! inclusive.
     * @return
     */
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] res = new int[n + 1];
        int[] nums = new int[n + 1];
        res[0] = 1;
        for (int j = 1; j <= n; j++) {
            res[j] = res[j - 1] * j;
            nums[j] = j;
        }
        int i = n - 1;
        while (i >= 0) {
            if (k == res[i]) {
                sb.append(nums[1]);
                for(int j=i+1;j>=2;j--){
                    sb.append(nums[j]);
                }
                return sb.toString();
            } else if (k > res[i]) {
                int num = (k - 1) / res[i];
                k = num == 0 ? k : k % res[i];
                sb.append(nums[num + 1]);
                shiftNums(nums, num + 2);
                if(k==0){
                    for(int j=i;j>=1;j--){
                        sb.append(nums[j]);
                    }
                    return sb.toString();
                }
            } else {
                // k < res[i]
                sb.append(nums[1]);
                shiftNums(nums,2);

            }
            i--;
        }
        return sb.toString();
    }

    private void shiftNums(int[] nums, int i) {
        while (i < nums.length) {
            nums[i - 1] = nums[i];
            i++;
        }
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        int n = 4;
        int k = 4;
//        System.out.println(permutationSequence.getPermutation(n, k));
        for(int i =1;i<=120;i++){
            System.out.println(permutationSequence.getPermutation(5, i));

        }
    }
}
