package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/3 17:29
 */

import java.util.HashMap;
import java.util.Map;

/***
 * 题目来源： https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 时间复杂度: o(n)
 * 思路：遍历字符串，记录已经访问过的字符，每次遇到相同的字符时，计算当前最大子串
 * 解：
 *  利用Map存储访问过的(字符,字符所处的位置)
 *  遍历字符串 ，如果当前字符被访问过 ，则head尝试移动(head只能往前走) ，并更新当前字符的位置
 *  若未访问过，记录当前字符及位置到map ，tail向前移动一步.
 *  当遍历完成后，计算最大子串.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int capacity = s.length() * 4 / 3 + 1;
        int res = 0;
        int head = 0; // 头
        int tail = -1; // 尾
        Map<Character, Integer> visited = new HashMap<>(capacity); // (字符，所处的位置)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited.containsKey(c)) {
                int len = tail - head + 1;
                if (len > res) {
                    res = len;
                }
                tail++;
                head = Math.max(visited.get(c) + 1,head);   // head只能往前走不能后退
                visited.put(c, i);
                continue;
            }
            visited.put(c, i);
            tail++;
        }
        res = Math.max(res,tail - head + 1);
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sub = new LongestSubstringWithoutRepeatingCharacters();
        String s ="abcabcbb";
//        String s = "abbac";
//        String s = "";
        System.out.println(sub.lengthOfLongestSubstring(s));
    }

}
