package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/5 17:16
 */
/***
 * 题目来源： https://leetcode.com/problems/length-of-last-word/
 * 时间复杂度 O(N) 空间复杂度 O(1)
 * 思路：从后遍历
 * 解：见代码 没啥好说的
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int res = 0;
        boolean canSpace =true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i)==' '){
                if(canSpace){
                    continue;
                }else{
                    return res;
                }
            }
            canSpace =false;
            res++;
        }
        return res;
    }
    public static void main(String[] args){
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String s = "hello world";
        System.out.println(lengthOfLastWord.lengthOfLastWord(s));
    }
}
