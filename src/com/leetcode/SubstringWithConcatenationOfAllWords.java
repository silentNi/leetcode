package com.leetcode;

import java.util.*;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/28 14:27
 */
/***
 * 题目来源： https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 时间复杂度 O(NM), where N=s.length(), M=words.size()
 * 思路：对于words数组构建 map < string，count of string appeared >
 * 解：对于所有可能的子字符串进行判断，将子字符串看做 M 段 对于其中的每一段进行匹配
 * 若能匹配，则 count of string appeared 若为1则从map中移除该 < k,v > 不然就将 count--
 * 不能匹配 ，则break 跳出当前循环 ，
 * 循环结束后判断map是否为空
 * 若为空则完全匹配 ，记录当前子字符串在s中的起始index
 * 若不为空则说明不能匹配，继续遍历下一个子字符串
 */
public class SubstringWithConcatenationOfAllWords {
    /**
     *
     * @param s 匹配串
     * @param words words数组中的字符串长度相等
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) {
            return res;
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        int sigleLen = words[0].length();
        int totalLen = words.length * sigleLen;
        for (int i = 0; i <= s.length() - totalLen; i++) {
            Map<String, Integer> copy = new HashMap<>(wordsMap);
            for (int j = 0; j < words.length; j++) {
                String temp = s.substring(i + j * sigleLen, i + (j + 1) * sigleLen);
                if(copy.containsKey(temp)){
                    int count =copy.get(temp);
                    if(count==1){
                        copy.remove(temp);
                    }else{
                        copy.put(temp,count-1);
                    }
                }else{
                    break;
                }
            }
            if(copy.isEmpty()){
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        String s = "wordgoodstudentgoodword";
//        String[] words = {"word", "good"};
//        String s = "wordgoodstudentgoodword";
//        String[] words = {"word", "student"};
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word","good","best","good"};
        String s = "a";
        String[] words = {};
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        System.out.println(substringWithConcatenationOfAllWords.findSubstring(s, words));
    }
}
