package com.leetcode;

import java.util.Arrays;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/29 10:45
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int first = nums[0];
        int idx = 0;
        for(int i=1;i<nums.length;i++){
            if(first!=Integer.MAX_VALUE){
                if(nums[i]==first){
                    first = Integer.MAX_VALUE;
                }else{
                    res[idx] = first;
                    first =nums[i];
                    idx++;
                    if(idx==2){
                        return res;
                    }
                }
            }else{
                first =nums[i];
            }

        }
        res[1]=nums[nums.length-1];
        return res;
    }
    public static void main(String[] args){
        int[] nums ={1,2,1,3,2,3,4,5};
        SingleNumberIII singleNumberIII = new SingleNumberIII();
        int[] res =singleNumberIII.singleNumber(nums);
        System.out.println(res[0]+" " +res[1]);
        String s =null ;
        String s1 ="null+"+s;
        System.out.println(s);
        System.out.println(s1);
    }
}
