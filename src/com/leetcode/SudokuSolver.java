package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/9 16:34
 */
/***
 * 题目来源： https://leetcode.com/problems/sudoku-solver/
 * 时间复杂度 递归难求不过肯定是常数级别的复杂度因为board规模固定为9*9大小 O(1) 空间复杂度 O(1)
 * 思路：递归回溯求解
 * 解 ：判断当前状态是否有效，找到第一个'.',尝试填充'1'到'9'之间的字符，
 * 判断是否有效，字符有效则将当前位置填充为该字符，判断下个状态是否有效，下个状态无效则回溯 ,字符无效继续填充下个字符
 * 当所有字符填充都无效时，递归结束 无解返回false
 * 找不到'.' 即9*9矩阵已经被填满 递归结束 得解
 */
public class SudokuSolver {
    /**
     * Set[][] sets = new HashSet[10][10];
     * boolean[][] visited = new boolean[10][10];
     * for (int i = 0; i < 10; i++) {
     * for (int j = 0; j < 10; j++) {
     * sets[i][j] = new HashSet<Character>();
     * visited[i][j] = false;
     * }
     * }
     * // queue 中存放 set大小为1 的 <i ,j>对 此时board[i][j]可求解
     * Queue<Integer> queue = new ArrayDeque<>();
     * for (int i = 0; i < 9; i++) {
     * for (int j = 0; j < 9; j++) {
     * if (board[i][j] != '.') {
     * visited[i][j] = true;
     * continue;
     * }
     * <p>
     * // board[i][j]=='.'
     * Set<Character> nowSet = new HashSet<>();
     * for (int idx = 0; idx < 9; idx++) {
     * if (board[i][idx] != '.') {
     * nowSet.add(board[i][idx]);
     * }
     * if (board[idx][j] != '.') {
     * nowSet.add(board[idx][j]);
     * }
     * }
     * // row = 0,3,6
     * int row = (i / 3) * 3;
     * // col = 0,3,6
     * int col = (j / 3) * 3;
     * for (int shift = 0; shift < 3; shift++) {
     * for (int down = 0; down < 3; down++) {
     * if (board[row + shift][col + down] != '.') {
     * nowSet.add(board[row + shift][col + down]);
     * }
     * }
     * }
     * for (int k = 1; k < 10; k++) {
     * char c = (char) (k + 48);
     * if (!nowSet.contains(c)) {
     * sets[i][j].add(c);
     * }
     * }
     * //                sets[i][j].removeAll(nowSet);
     * if (sets[i][j].size() == 1) {
     * queue.add(i * 10 + j);
     * }
     * }
     * }
     * <p>
     * for (int i = 0; i < 9; i++) {
     * for (int j = 0; j < 9; j++) {
     * System.out.print(sets[i][j].size() + "  ");
     * }
     * System.out.println();
     * }
     * while (!queue.isEmpty()) {
     * int sum = queue.poll();
     * // 求解该位置上的值
     * int i = sum / 10;
     * int j = sum % 10;
     * if (visited[i][j]) {
     * continue;
     * }
     * // c 为i,j位置上的解
     * char c = '.';
     * for (int k = 1; k < 10; k++) {
     * c = (char) (k + 48);
     * if (sets[i][j].contains(c)) {
     * board[i][j] = c;
     * sets[i][j].clear();
     * visited[i][j] = true;
     * break;
     * }
     * }
     * // 更新同行或同列的 set
     * for (int idx = 0; idx < 9; idx++) {
     * if (board[i][idx] == '.') {
     * sets[i][idx].remove(c);
     * if (sets[i][idx].size() == 1) {
     * queue.add(i * 10 + idx);
     * }
     * }
     * if (board[idx][j] == '.') {
     * sets[idx][j].remove(c);
     * if (sets[idx][j].size() == 1) {
     * queue.add(idx * 10 + j);
     * }
     * }
     * }
     * // 更新 同一个3*3方阵内的set
     * // row = 0,3,6
     * int row = (i / 3) * 3;
     * // col = 0,3,6
     * int col = (j / 3) * 3;
     * for (int shift = 0; shift < 3; shift++) {
     * for (int down = 0; down < 3; down++) {
     * if (board[row + shift][col + down] == '.') {
     * sets[row + shift][col + down].remove(c);
     * if (sets[row + shift][col + down].size() == 1) {
     * queue.add((row + shift) * 10 + col + down);
     * }
     * }
     * }
     * }
     * }
     *
     * @param board
     * @return
     */
    public void solveSudoku(char[][] board) {
        fillSudoku(board);
    }
    public boolean fillSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidSudoku(board, i, j, c)) {
                            board[i][j] = c;
                            if (fillSudoku(board)) {
                                return true;
                            }
                            // 回溯
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }




    public boolean isValidSudoku(char[][] board, int i, int j, char c) {
        // 1.check row
        // 2.check column
        // 3.check the 3*3 box
        for (int k = 0; k < 9; k++) {
            // 检查第i行是否有效
            if (board[i][k] == c) {
                return false;
            }
            // 检查第j列是否有效
            if (board[k][j] == c) {
                return false;
            }
            if (board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
//        char[][] sudoku = {
//                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
//                {'7', '.', '.', '6', '.', '2', '.', '.', '.'},
//                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
//                {'.', '.', '7', '9', '8', '6', '2', '4', '1'},
//                {'2', '6', '4', '3', '1', '7', '5', '9', '8'},
//                {'1', '9', '8', '5', '2', '4', '3', '6', '7'},
//                {'.', '.', '.', '8', '6', '3', '.', '2', '.'},
//                {'.', '.', '.', '4', '9', '1', '.', '.', '6'},
//                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
//        };
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(sudoku);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + "  ");
            }
            System.out.println();
        }
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(sudoku));


        // Test
//        Pair<Integer, Integer> pair = new Pair<>(1, 1);
//        System.out.println(pair.getKey());
//        System.out.println(pair.getValue());
//        for (int i = 0; i < 9; i++) {
//            char c = (char) (i + 48);
//            System.out.println(c);
//        }

//        Set[][] sets = new HashSet[10][10];
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                sets[i][j] = new HashSet<Character>();
//            }
//        }
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                sets[i][j].add('0');
//            }
//        }
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.println(sets[i][j]);
//            }
//        }

    }
}
