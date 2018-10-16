package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/15 14:21
 */
/***
 * 题目来源： https://leetcode.com/problems/multiply-strings/
 * 时间复杂度 O(logN + logM + logN*logM + logN+logM ) N=num1.length M=num2.length 空间复杂度 O(logN + logM)
 * 思路：将字符串分段处理 有点类似于分治
 * 解：将字符串每四个字符分成一个新字符串形成int数组，分而治之，
 * 每次将同一段的值相加，判断是否需要进位
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] s1 = convert(num1);
        int[] s2 = convert(num2);
        int resSize = s1.length + s2.length + 1;
        int[] res = new int[resSize];
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                int sum = s1[i] * s2[j];
                int add = sum / 10000;
                int remain = sum % 10000;
                int carry = 0;
                int low = res[i + j] + remain;
                res[i + j] = low % 10000;
                if (low >= 10000) {
                    carry = 1;
                }
                int high = res[i + j + 1] + add + carry;
                carry = 0;
                res[i + j + 1] = high % 10000;
                if (high >= 10000) {
                    carry = 1;
                }
                // 处理可能的进位 （ps:可以将所有的进位放到循环外去做一次循环处理）
                int k = 2;
                while (carry == 1) {
                    int value = res[i + j + k] + carry;
                    res[i + j + k] = value % 10000;
                    k++;
                    if (value < 10000) {
                        carry = 0;
                    }
                }
            }
        }
        // 形成字符串解
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = res[res.length - 1] == 0;
        boolean first = true;
        for (int i = res.length - 1; i >= 0; i--) {
            if (leadingZero && i > 0) {
                leadingZero = res[i - 1] == 0;
                continue;
            }
            if (!first) {
                //  除了第一次都需要补充前导0  如"5" --> "0005"
                if(res[i]<10){
                    sb.append("000");
                }else if(res[i]<100){
                    sb.append("00");
                }else if(res[i]<1000){
                    sb.append("0");
                }
            }
            sb.append(res[i]);
            first = false;
        }
        return sb.toString();
    }

    private int[] convert(String num1) {
        int len = num1.length() - 1;
        int[] res = new int[len / 4 + 1];
        int idx = 0;
        int i = len;
        while (i >= 3) {
            res[idx++] = Integer.valueOf(num1.substring(i - 3, i + 1));
            i = i - 4;
        }
        if (i >= 0) {
            res[idx] = Integer.valueOf(num1.substring(0, i + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String num1 = "10000";
        String num2 = "10";
        System.out.println(multiplyStrings.multiply(num1, num2));
    }
}
