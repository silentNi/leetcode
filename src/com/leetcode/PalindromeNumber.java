package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/12 11:22
 */
/***
 * 题目来源： https://leetcode.com/problems/palindrome-number/description/
 * 时间复杂度 o(1)
 * 思路：为啥好说的 太简单了 （另一种思路不将整数转化为str ， 求出整数的倒序整数，判断是否相等）
 * 解：略
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int right = s.length()-1;
        int left = 0;
        while (left < right) {
            if (s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args){
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x=123445321;
        System.out.println(palindromeNumber.isPalindrome(x));
    }
}
