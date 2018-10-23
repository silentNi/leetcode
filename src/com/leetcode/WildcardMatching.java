package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/16 15:18
 */
/***
 * 题目来源： https://leetcode.com/problems/wildcard-matching/
 * 时间复杂度 最好O(N+M) N=s.length M=p.length 最坏O(N*M) 空间复杂度O(1)
 * 思路：双指针 每次必有一个指针往后走
 * 解：
 */
public class WildcardMatching {
    /**
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     *
     * @param s s could be empty and contains only lowercase letters a-z.
     * @param p p could be empty and contains only lowercase letters a-z, and characters like ? or *.
     * @return
     */
    public boolean isMatch(String s, String p) {
        int si = 0, pi = 0, match = 0, start = -1;
        while (si < s.length()) {
            if (pi < p.length() && (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))) {
                // 匹配单个字符
                si++;
                pi++;
            } else if (pi < p.length() && p.charAt(pi) == '*') {
                // 遇到* 更新match 和start ；pi向后走
                match = si;
                start = pi;
                pi++;
            } else if (start != -1) {
                //  上一个*多匹配一个字符 match++
                match++;
                si = match;
                pi = start + 1;
            } else {
                // 都不匹配且上一个*不存在
                return false;
            }
        }
        while (pi < p.length() && p.charAt(pi) == '*') {
            pi++;
        }
        return pi == p.length();
    }

    private boolean judge(String s, String p, int si, int pi) {
        if (s.length() == si) {
            if (p.length() == pi) {
                return true;
            } else {
                if (p.charAt(pi) == '*') {
                    while (pi < p.length() && p.charAt(pi) == '*') {
                        pi++;
                    }
                    return judge(s, p, si, pi);
                } else {
                    return false;
                }
            }
        }
        if (p.length() == pi) {
            return false;
        }
        // n , m
        if (p.length() - 1 == pi && p.charAt(pi) == '*') {
            return true;
        }

        if (p.charAt(pi) == '?') {
            // 匹配一个值
            return judge(s, p, si + 1, pi + 1);
        } else if (p.charAt(pi) == '*') {
            while (pi < p.length() && p.charAt(pi) == '*') {
                pi++;
            }
            // 匹配任意长度的字符串
            for (int i = 0; i <= s.length() - si; i++) {
                if (judge(s, p, si + i, pi)) {
                    return true;
                }
            }
            return false;
        } else {
            // a-z
            return s.charAt(si) == p.charAt(pi) && judge(s, p, si + 1, pi + 1);
        }
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
//        String s = "ab";
//        String p = ".*a";
        long start = System.currentTimeMillis();
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        System.out.println(wildcardMatching.isMatch(s, p));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
