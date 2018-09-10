package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/10 10:00
 */
/***
 * 题目来源： https://leetcode.com/problems/zigzag-conversion/description/
 * 时间复杂度 O(n)
 * 思路：记录每层的字符串
 * 解：根据字符串转化规则 下 斜上 下 斜上 ......
 * sb[idx].toString() 表示 第idx层所记录的字符串
 * 遍历字符串 一次循环 -- > 先是向下 从 0 到 numRows-1 层 ，然后斜向上 从 numRows-2 到 1 层
 * 字符串未完全遍历则继续。
 * 最后将每一层的字符串依次拼接 得到所求字符串
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n < numRows || numRows == 1) {
            return s;
        }
        char[] c = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[n];
        for (int k = 0; k < n; k++) {
            sb[k] = new StringBuilder();
        }
        int i = 0;
        int idx = 0;
        while (i < n) {
            for (idx = 0; idx < numRows && i < n; idx++) {
                sb[idx].append(c[i++]);
            }
            for (idx = numRows - 2; idx > 0 && i < n; idx--) {
                sb[idx].append(c[i++]);
            }
        }
        for (int j = 1; j < n; j++) {
            sb[0].append(sb[j].toString());
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
//        String s = "PAYPALISHIRING";
        String s = "";
        int n = 4;
        ZigZagConversion zig = new ZigZagConversion();
        System.out.println(zig.convert(s, n));
    }
}
