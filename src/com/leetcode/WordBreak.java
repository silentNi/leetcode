package com.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/26 11:26
 */
/***
 * 题目来源： https://leetcode.com/problems/word-break/
 * 时间复杂度 O(NM) 空间复杂度 O(N) , N=s.length() M=wordDict.size()
 * 思路：带备忘的自顶向下法
 * 解：p[i] 表示 字符串s.substring(0,i)的可能性  1:true -1:fasle 0:未计算
 * 原问题可以由子问题的最优解构成
 * 符合最优子结构和重叠子问题的性质，适合用DP
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] p = new int[s.length() + 1]; // 备忘 1:true -1:fasle 0:未计算
        return solver(p, s, wordDict, s.length());
    }

    private boolean solver(int[] p, String s, List<String> wordDict, int idx) {
        if (idx == 0) {
            return true;
        }
        if (p[idx] != 0) {
            return p[idx] == 1;
        }
        for (String word : wordDict) {
            if (word.length() <= idx && word.equals(s.substring(idx - word.length(), idx))) {
                boolean res = solver(p, s, wordDict, idx - word.length());
                if (res) {
                    p[idx] = 1;
                    return true;
                }
            }
        }
        p[idx] = -1;
        return false;
    }

    public static void main(String... args) {
        WordBreak wordBreak = new WordBreak();
//        List<String> words = Arrays.asList("cats", "dog", "sand", "and", "cat");
//        String s = "catsandog";
        List<String> words = Arrays.asList("apple", "pen","penapples");
        String s = "applepenapples";
        System.out.println(wordBreak.wordBreak(s, words));
    }
}
