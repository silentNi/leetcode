package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/17 16:21
 */
/***
 * 题目来源： https://leetcode.com/problems/integer-to-roman/description/
 * 时间复杂度 o(n)???  这一类的时间复杂度该如何计算？
 * 思路：将数值与罗马符号一一对应。
 * 解：辗转相除法
 */
public class IntegerToRoman {
    public static int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            int temp = num / value[i];
            num = num % value[i];
            while (temp > 0) {
                sb.append(symbol[i]);
                temp--;
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        int num = 1;
        System.out.println(integerToRoman.intToRoman(num));
        for (int i = 1; i <= 3999; i++) {
            System.out.println(integerToRoman.intToRoman(i) + " --> " + i);
        }
    }
}
