package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/21 15:56
 */
/***
 * 题目来源： https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 时间复杂度 难求
 * 思路：关键在于如何扩张
 * 解：对于字符串中的每一个数字进行一次扩张
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>(16);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        int n = digits.length();
        StringBuilder[] resArray = null;
        for (int i = 0; i < n; i++) {
            char c = digits.charAt(i);
            if ('1' < c && c <= '9' && map.containsKey(c)) {
                String s = map.get(c);
                int last_len = resArray != null ? resArray.length : 1;
                // 扩张
                StringBuilder[] new_resArray = new StringBuilder[s.length() * last_len];
                int idx = 0;
                if (resArray != null) {
                    for (StringBuilder res : resArray) {
                        for (int j = 0; j < s.length(); j++) {
                            new_resArray[idx] = new StringBuilder(res.toString());
                            new_resArray[idx].append(s.charAt(j));
                            idx++;
                        }
                    }
                } else {
                    for (int j = 0; j < s.length(); j++) {
                        new_resArray[idx] = new StringBuilder();
                        new_resArray[idx].append(s.charAt(j));
                        idx++;
                    }
                }
                resArray = new_resArray;
            }
        }
        List<String> ans = new ArrayList<>(resArray.length);
        for (StringBuilder res : resArray) {
            ans.add(res.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "23456789";
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(s));
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(s).size());
    }
}
