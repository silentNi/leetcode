package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/19 15:40
 */
/***
 * 题目来源： https://leetcode.com/problems/group-anagrams/
 * 时间复杂度 O(NK) N=strs.length(数组的大小) K=str.length(字符串的大小) 空间复杂度 O(NK)
 * 思路：用字符串中字符出现的次数作为key来判断是否是同一类字符串 --即找到一个合适的hashcode计算方式
 * 解：同思路
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            char[] record = new char[27];
            for(int i=0;i<str.length();i++){
                record[str.charAt(i)-'a']++;
            }
            List<String> t;
            String key = String.valueOf(record);
            if(map.containsKey(key)){
                t= res.get(map.get(key));
            }else{
                t= new ArrayList<>();
                res.add(t);
                map.put(key,res.size()-1);
            }
            t.add(str);
        }
        return res;
    }
    public static void main(String[] args){
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs ={
                "eate",
                "teae",
                "tan",
                "atee",
                "nat",
                "bat"
        };
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
