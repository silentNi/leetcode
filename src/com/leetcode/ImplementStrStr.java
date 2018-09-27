package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/27 15:30
 */
/***
 * 题目来源： https://leetcode.com/problems/implement-strstr/
 * 时间复杂度 o(n)
 * 思路：仿照indexOf()函数的实现逻辑 不能直接使用indexOf()不然就没有写这道题的必要了。
 *       工程中直接调用这类函数可以，但是刷题必须要知道它的底层实现逻辑
 * 解：遍历匹配串（预留一段长度给模式串匹配），
 * 找到匹配串的char与模式串的第一个char相匹配 ，判断其后的char是否完全匹配
 * 若完全匹配 返回解
 * 否则继续遍历匹配串直到遍历完成 返回无解值
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        char[] base = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        for (int i = 0; i <= base.length - pattern.length; i++) {
            if (base[i] == pattern[0]) {
                int len =0;
                for (int j = 0; j < pattern.length; j++) {
                    if (base[i + j] != pattern[j]) {
                        break;
                    }else{
                        len++;
                    }
                }
                if(len == pattern.length){
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        // String haystack, String needle
        String haystack ="aaaaa";
        String needle ="bba";
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(haystack.indexOf(needle));
        System.out.println(implementStrStr.strStr(haystack,needle));
    }
}
