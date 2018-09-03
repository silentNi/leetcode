package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/3 10:35
 */

/***
 * 时间复杂度o(n)
 * 思路：考虑到循环遍历数组的方式来获取结果太慢，时间复杂度需要o(n^2) = n-1 + n-2 + …… + 1
 * 利用Map的特性，寻找key的时间为o(1),
 * 解：
 * map中存储 map< 所需的另一个值,前一个值的序号 >
 * 循环一次数组 对数组中的每个元素nums[i]进行判断，当前的map的keys中是否有该元素，
 * 如果有则得出结果 [map.get(nums[i]),i] ，
 * 没有则将当前值所需要的另一个值和当前值的序号放入map中,即map.put(target-nums[i],i)
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer ,Integer> resMap = new HashMap<>(nums.length);
        for (int i= 0;i<nums.length;i++){
            if(resMap.containsKey(nums[i])){
                return new int[]{resMap.get(nums[i]),i};
            }
            resMap.put(target-nums[i],i);
        }
        return null;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{2,7,11,15};
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int target =17;
        TwoSum twoSum = new TwoSum();
        int[] ans =twoSum.twoSum(nums,target);
        System.out.println(ans[0]+" "+ans[1] );
    }
}
