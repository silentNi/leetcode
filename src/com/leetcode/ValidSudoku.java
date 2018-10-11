package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/9 14:33
 */
/***
 * 题目来源： https://leetcode.com/problems/valid-sudoku/
 * 时间复杂度 O(2*9*9+9*9) 空间复杂度 O(2*9*9+9*9)
 * 思路：按照题目的要求对数独数组进行验证 ，按部就班
 * 解：见代码
 */
public class ValidSudoku {
    /**
     * 检查数独是否是有效的，有效不一定等于有解。
     * 1.check rows
     * 2.check columns
     * 3.check the 9 3x3 sub-boxes
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 1.check rows
        // 2.check columns
        for (int i = 0; i < 9; i++) {
            // 检查第i行i列是否有效
            if (!checkRow(board, i)) {
                return false;
            }
            if (!checkColumn(board, i)) {
                return false;
            }
        }
        // 3.check the 9 3x3 sub-boxes
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!checkSubBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSubBox(char[][] board, int i, int j) {
        boolean[] check = new boolean[10];
        for (int shift = 0; shift < 3; shift++) {
            for (int down = 0; down < 3; down++) {
                if (board[i + shift][j + down] != '.') {
                    int num =board[i + shift][j + down] -'0';
                    if (check[num]) {
                        return false;
                    } else {
                        check[num]=true;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkColumn(char[][] board, int col) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.') {
                int num =board[i][col] -'0';
                if (check[num]) {
                    return false;
                } else {
                    check[num]=true;
                }
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                int num =board[row][i] -'0';
                if (check[num]) {
                    return false;
                } else {
                    check[num]=true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {


    }


}
