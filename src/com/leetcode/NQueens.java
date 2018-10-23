package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/23 10:56
 */
/***
 * 题目来源： https://leetcode.com/problems/n-queens/
 * 时间复杂度 O(n^2) 空间复杂度 O(n^2)
 * 思路：递归回溯
 * 解：每行填一个Queen，填完后将其他行不能的填的位置更新，进入下一次递归，
 * 不满足条件或得解 --> 回溯（将不能填的位置更新）判断下一个位置
 *
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[][] placeHold = new int[n][n];
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(res, placeHold, matrix, 0);
        return res;
    }

    private void solve(List<List<String>> res, int[][] placeHold, char[][] matrix, int row) {
        if (row == matrix.length) {
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix.length; j++) {
//                    System.out.print(placeHold[i][j]+" ");
//                }
//                System.out.println();
//            }
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix.length; j++) {
//                    System.out.print(matrix[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("-------------------");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                list.add(String.valueOf(matrix[i]));
            }
            res.add(list);
            return;
        }
        for (int k = 0; k < matrix.length; k++) {
            if (placeHold[row][k]==0) {
                // 更新placeHold[][]
                // 右下
                for (int idx = k; idx < matrix.length; idx++) {
                    if(row + idx - k < matrix.length){
                        placeHold[row + idx - k][idx]++;
                    }else{
                        break;
                    }
                }
                // 左下
                for (int idx = k; idx >= 0; idx--) {
                    if(row + k-idx<matrix.length){
                        placeHold[row + k-idx][idx]++;
                    }else{
                        break;
                    }
                }
                // 竖直向下
                for (int idx = row; idx<matrix.length; idx++) {
                    placeHold[idx][k]++;
                }

                matrix[row][k] = 'Q';
                solve(res, placeHold, matrix, row + 1);
                matrix[row][k] = '.';
                // 还原placeHold[][]
                // 右下
                for (int idx = k; idx < matrix.length; idx++) {
                    if(row + idx - k < matrix.length){
                        placeHold[row + idx - k][idx]--;
                    }else{
                        break;
                    }
                }
                // 左下
                for (int idx = k; idx >= 0; idx--) {
                    if(row + k-idx<matrix.length){
                        placeHold[row + k-idx][idx]--;
                    }else{
                        break;
                    }
                }
                // 竖直向下
                for (int idx = row; idx<matrix.length; idx++) {
                    placeHold[idx][k]--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n=8;
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(n));
        System.out.println(nQueens.solveNQueens(n).size());
    }
}
