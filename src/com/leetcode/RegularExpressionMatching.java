package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/13 9:44
 */
/***
 * 题目来源： https://leetcode.com/problems/regular-expression-matching/description/
 * 时间复杂度 ??
 * 思路：见代码注解
 * 解：  见代码注解
 */
public class RegularExpressionMatching {
    /**
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     *
     * @param s could be empty and contains only lowercase letters a-z.
     * @param p could be empty and contains only lowercase letters a-z, and characters like . or *.
     * @return Is the matching cover the entire input string (not partial).
     */
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() == 0) {
            if (p.length() >= 2 && p.charAt(1) == '*') {
                // 如  s = "" p = "a*b*" --> s = "" p = "b*" --> s = "" p = ""
                return isMatch(s,p.substring(2));
            }
            return false;
        }
        if (p.length() == 0) {
            return false;
        }
        // when reach here : s.length >= 1 &&  p.length >= 1
        if (p.length() == 1) {
            if (s.length() == 1) {
                if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                    return true;
                }
                return false;
            }
            return false;
        }
        // when reach here : s.length >= 1 &&  p.length >= 2
        // 开始缩小问题规模
        if (s.charAt(0) == p.charAt(0)) {
            // s[0] == p[0]
            if (p.charAt(1) == '*') {
                // 循环 去判断是否匹配
                /**
                 * 如  s = "aaaabb" p = "a*bb"
                 * --> s = "aaaabb" p = "bb"  (a*不匹配)
                 * --> s = "aaabb" p = "bb"   (a*匹配 a)
                 * --> s = "aabb" p = "bb"    (a*匹配 aa)
                 * --> s = "abb" p = "bb"     (a*匹配 aaa)
                 * --> s = "bb" p = "bb"      (a*匹配 aaaa) true
                 */
                int idx = 0;
                while (idx < s.length() && s.charAt(idx) == p.charAt(0)) {
                    // a*匹配
                    boolean ismatch = isMatch(s.substring(idx + 1), p.substring(2));
                    idx++;
                    if (ismatch) {
                        // 只要有一次匹配就结束
                        return true;
                    }
                }
                // a*不匹配
                return isMatch(s, p.substring(2));

            }
            // 如 s = "mississippi" p = "mis*is*p*." --> s = "ississippi" p = "is*is*p*."
            return isMatch(s.substring(1), p.substring(1));
        }
        if (p.charAt(0) == '.') {
            // s[0] != p[0] && p[0]=='.'
            if (p.charAt(1) == '*') {
                // s[0] != p[0] && p[0]=='.' && p[1]=='*'
                /**
                 * 如  s = "ababcd" p = ".*bcd"
                 * --> s = "ababcd" p = "bcd"  (.*不匹配)
                 * --> s = "babcd" p = "bcd"   (.*匹配 a)
                 * --> s = "abcd" p = "bcd"    (.*匹配 ab)
                 * --> s = "bcd" p = "bcd"     (.*匹配 aba)  true
                 * --> s = "cd" p = "bcd"      (.*匹配 abab)
                 * --> s = "d" p = "bcd"       (.*匹配 ababc)
                 * --> s = "" p = "bcd"        (.*匹配 ababcd) .*全匹配
                 */
                int idx = 0;
                while (idx <= s.length()) {
                    boolean isMatch = isMatch(s.substring(idx), p.substring(2));
                    if (isMatch) {
                        return true;
                    }
                    idx++;
                }
                return false;
            }
            // s[0] != p[0] && p[0]=='.' && p[1]!='*'
            // 如  s = "abcd" p = ".bcd" --> s = "bcd" p = "bcd"
            return isMatch(s.substring(1), p.substring(1));
        }
        // s[0] 与 p[0]不匹配时 看p[1]是否为 '*'
        if (p.charAt(1) == '*') {
            // 如 s = "aab" p = "c*a*b" --> s = "aab" p = "a*b"
            return isMatch(s, p.substring(2));
        }
        // when reach here : s 与 p 不匹配
        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatching re = new RegularExpressionMatching();
//        String s = "ab";
//        String p = ".*a";
        String s = "aab";
        String p = "c*a*b";
        System.out.println(re.isMatch(s, p));
    }
}
