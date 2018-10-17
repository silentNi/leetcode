package com.leetcode;

import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/16 15:18
 */
/***
 * 题目来源： https://leetcode.com/problems/wildcard-matching/
 * 时间复杂度 递归超时了。 空间复杂度 O(1)
 * 思路：和之前的正则表达式匹配一样的思路
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
        return judge(s,p,0,0);
    }

    private boolean judge(String s, String p, int si, int pi) {
        if (s.length() == si) {
            if(p.length() == pi){
                return true;
            }else{
                if(p.charAt(pi)=='*'){
                    while (pi < p.length() && p.charAt(pi) == '*') {
                        pi++;
                    }
                    return judge(s,p,si,pi);
                }else{
                    return false;
                }
            }
        }
        if (p.length() == pi) {
            return false;
        }
        // n , m
        if (p.length()-1 == pi && p.charAt(pi) == '*') {
            return true;
        }

        if (p.charAt(pi) == '?') {
            // 匹配一个值
            return judge(s, p,si+1,pi+1);
        } else if (p.charAt(pi) == '*') {
            while (pi < p.length() && p.charAt(pi) == '*') {
                pi++;
            }
            // 匹配任意长度的字符串
            for (int i = 0; i <= s.length() - si; i++) {
                if (judge(s, p,si+i,pi)) {
                    return true;
                }
            }
            return false;
        } else {
            // a-z
            return s.charAt(si) == p.charAt(pi) && judge(s, p,si+1,pi+1);
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
        System.out.println(end-start);

    }
}
