package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/7 10:41
 */
/***
 * 题目来源： https://leetcode.com/problems/two-sum/description/
 * 时间复杂度 O(N) N=s.length 空间复杂度 O(1)
 * 思路：
 * 解： 见代码
 * 对每个字符可能的五种情况进行判断，合理继续，不合理false
 Numbers 0-9
 Exponent - "e"
 Positive/negative sign - "+"/"-"
 Decimal point - "."
 other
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        int i =0;
        boolean canSign = true; // 后面是否可以有 + or -
        boolean canDot = true; // 后面是否可以有 .
        boolean canE= false;   // 后面是否可以有 E
        boolean afterE =false; // 前面有过 E
        boolean dotBefore =false; // 前面有过 .
        boolean afterSpace =false; // 前面有过 space
        boolean continueSpace=false; // 过滤字符串从头开始的连续space
        int countSpace= 0;    //  出现的空格数
        char last = s.charAt(i); //  记录最后一个字符
        while(i<s.length()){
            char c=s.charAt(i);
            if(c==' '){
                countSpace++;
                i++;
                if(!afterSpace){
                    continue;
                }
                continueSpace =true;
                continue;

            }
            afterSpace=true;
            if(continueSpace){
                return false;
            }
            last=c;
            if((c=='-'||c=='+') && canSign){
                canSign=false;
                i++;
                continue;
            }

            if(c-'0'>=0 && c-'0'<=9){
                i++;
                canSign=false;
                canE=!afterE;
                canDot=!afterE && !dotBefore;
                continue;
            }
            if(c=='e' && canE){
                i++;
                afterE =true;
                canE = false;
                canSign = true;
                canDot = false;
                continue;
            }
            if(c=='.' && canDot){
                canDot=false;
                dotBefore=true;
                canSign=false;

                i++;
                continue;
            }
            return false;
        }
        //      最后一个字符是数字" 12343"    or    " 12344."     or  "    1   "
        return (0<=last-'0' && last-'0' <=9) || (last=='.'&&canE) || (last==' ' && countSpace!=s.length());
    }
}
