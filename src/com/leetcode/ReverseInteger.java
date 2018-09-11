package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/11 10:43
 */
/***
 * 题目来源： https://leetcode.com/problems/reverse-integer/description/
 * 时间复杂度 O(1)
 * 思路：x从低位往高位遍历 直到得出结果或者溢出  （思路2：可以用long来存储结果最后对比是否溢出。）
 * 解：先判断x的正负，x=|x| ,对x取模取余 直到x==0或溢出 （溢出判断 当temp=res*10+mod不能通过反向操作回去时则说明有溢出 ）
 */
public class ReverseInteger {
    public int reverse(int x) {
        // -2^31 --> 2^31 overflow
        if (x == 0) {
            return 0;
        }
        int res = 0;
        int sign = (x > 0) ? 1 : -1;
        x = Math.abs(x);
        while (x > 0) {
            int mod = x % 10;
            int temp = res * 10 + mod;
            if( (temp-mod)/10 !=res){
                // != 时说明已经溢出
                return 0;
            }
            res =temp;
            x = x / 10;
        }
        return res * sign;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
//        int x=Integer.MAX_VALUE;
//        int x=746384741;
//        int x=2000000000;
//        int x=1534236469;
//        int x=2147483647;
        int x=1463847412;
        System.out.println(reverseInteger.reverse(x));
    }
}
