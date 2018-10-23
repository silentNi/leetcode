package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/23 16:25
 */
/***
 * 题目来源： https://leetcode.com/problems/n-queens-ii/
 * 时间复杂度 O(N^2) 空间复杂度 O(1)
 * 思路：递归回溯
 * 解：和NQueens一样的方法，解的记录方式不同而已
 */
public class NQueensII {
    public int totalNQueens(int n) {
        int[][] placeHold = new int[n][n];
        return solve(placeHold, 0);
    }
    private int solve(int[][] placeHold, int row) {
        if (row == placeHold.length) {
            return 1;
        }
        int ans =0;
        for (int k = 0; k < placeHold.length; k++) {
            if (placeHold[row][k]==0) {
                // 更新placeHold[][]
                // 右下
                for (int idx = k; idx < placeHold.length; idx++) {
                    if(row + idx - k < placeHold.length){
                        placeHold[row + idx - k][idx]++;
                    }else{
                        break;
                    }
                }
                // 左下
                for (int idx = k; idx >= 0; idx--) {
                    if(row + k-idx<placeHold.length){
                        placeHold[row + k-idx][idx]++;
                    }else{
                        break;
                    }
                }
                // 竖直向下
                for (int idx = row; idx<placeHold.length; idx++) {
                    placeHold[idx][k]++;
                }
                ans += solve(placeHold, row + 1);
                // 还原placeHold[][]
                // 右下
                for (int idx = k; idx < placeHold.length; idx++) {
                    if(row + idx - k < placeHold.length){
                        placeHold[row + idx - k][idx]--;
                    }else{
                        break;
                    }
                }
                // 左下
                for (int idx = k; idx >= 0; idx--) {
                    if(row + k-idx<placeHold.length){
                        placeHold[row + k-idx][idx]--;
                    }else{
                        break;
                    }
                }
                // 竖直向下
                for (int idx = row; idx<placeHold.length; idx++) {
                    placeHold[idx][k]--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        NQueensII nQueensII = new NQueensII();
        NQueens nQueens = new NQueens();
        int n=5;
        for(int i =0;i<20;i++){
            System.out.println(i+" " +nQueensII.totalNQueens(i) + " " +nQueens.solveNQueens(i).size());
        }
    }
}
