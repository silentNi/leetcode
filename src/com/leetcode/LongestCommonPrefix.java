package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/18 10:57
 */
/***
 * 题目来源： https://leetcode.com/problems/longest-common-prefix/description/
 * 时间复杂度 --- 不好判断.应该不会超过O(n)
 * 思路：
 * 解：对strs中的每个字符串的第idx个字符进行判断，如果全相等则idx++,继续判断；
 * 直到全部idx越界或者有字符不相等
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return strs[0];
        }
        int idx = 0;
        boolean start = true;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (idx >= strs[i].length() || strs[0].charAt(idx) != strs[i].charAt(idx)) {
                    start = false;
                    break;
                }

            }
            if (!start) {
                break;
            }
            idx++;
        }
        return idx == 0 ? "" : strs[0].substring(0, idx);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {
                "aflow",
                "bflow",
                "flow"
        };
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
