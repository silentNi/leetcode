package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/18 9:59
 */
/***
 * 题目来源： https://leetcode.com/problems/roman-to-integer/description/
 * 时间复杂度 o(n)
 * 思路：将数值与罗马符号一一对应。
 * 解：上一题(Q12)的逆向思维 从左到右遍历出s中对应的所有罗马字符转化为数值。
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int res = 0;
        char[] c = s.toCharArray();
        int idx = 0;
        int i = 0;
        while (idx < c.length) {
            if (i % 2 == 0) {
                // symbol[0，2，4，6，8……]
                if (c[idx] == symbol[i].charAt(0)) {
                    res += value[i];
                    idx++;
                    continue;
                }
                i++;
            } else {
                // symbol[1,3,5,7,9……]
                if (idx < c.length - 1 && c[idx] == symbol[i].charAt(0) && c[idx + 1] == symbol[i].charAt(1)) {
                    res += value[i];
                    idx += 2;
                    continue;
                }
                i++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        RomanToInteger romanToInteger = new RomanToInteger();
        IntegerToRoman integerToRoman = new IntegerToRoman();
        for (int i = 1; i <= 3999; i++) {
//            System.out.println( i+ " --> " +  integerToRoman.intToRoman(i)+ " --> " +romanToInteger.romanToInt(integerToRoman.intToRoman(i)));
            if (romanToInteger.romanToInt(integerToRoman.intToRoman(i))!=i){
                System.out.println(i +"is convert error");
            }
        }
    }
}
