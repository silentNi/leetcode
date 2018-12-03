package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/26 16:31
 */
/***
 * 题目来源： https://leetcode.com/problems/word-break-ii/
 * 时间复杂度 -- 空间复杂度 --
 * 思路：DP 符合最优子结构和重叠子问题
 * 解：
 * 1. 刻画一个最优解的结构特征
 * wordBreak(s(i,...,n)) = word + wordBreak(s(i+word.length,...,n))
 * where word is in wordDict
 * 2. 递归地定义最优解的值
 *                          = ""    (s.length==0)
 * wordBreak(s(i,...,j))
 *                          = ∑(for each word in wordDict if word is suitable ) word + wordBreak(s(i+word.length,...,j))  (s.length>0)
 * 3. 计算最优解的值
 * 见代码
 * 4. 利用计算出的信息构造一个最优解
 * 见代码
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res =solver(s,wordDict,new HashMap<>());
        return res;
    }

    private List<String> solver( String s, List<String> wordDict,HashMap<String,List<String>> map) {
        if(map.containsKey(s)){
            return map.get(s);
        }

        List<String> res = new ArrayList<>();
        if(s.length()==0){
            res.add("");
            return res;
        }
        for(String word:wordDict){
            if(s.startsWith(word)){
                List<String> nexts= solver(s.substring(word.length()),wordDict,map);
                for(String next :nexts){
                    res.add(word + (next.isEmpty()?"":" ")+next);
                }
            }
        }
        map.put(s,res);
        return res;
    }

    public static void main(String... args) {
    WordBreakII wordBreak = new WordBreakII();
    List<String> words = Arrays.asList("cats", "dog", "sand", "and", "cat");
    String s = "catsanddog";
//    List<String> words = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa");
//    String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//    List<String> words = Arrays.asList("cats", "dog", "sand", "and", "cat");
//    String s = "catsandog";
    System.out.println(wordBreak.wordBreak(s, words));
}

}
