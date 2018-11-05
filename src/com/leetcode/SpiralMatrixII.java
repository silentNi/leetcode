package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/5 17:27
 */
/***
 * 题目来源： https://leetcode.com/problems/spiral-matrix-ii/
 * 时间复杂度 O(N^2) 空间复杂度 O(N^2)
 * 思路：每一圈操作分为四步 左下右上
 * 解：递归生成每一个外圈的数值，递归结束条件-外圈的sized大小为1或者0
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        solver(res, 1, 0, n - 1, 0, n - 1);
        return res;
    }

    private void solver(int[][] res, int now, int left, int right, int up, int down) {
        if (left > right ) {
            return;
        }else if(left==right){
            res[left][up]=now;
            return;
        }
        // 左 下 右 上
        int i = left;
        int j = up;
        for (; j < right; j++) {
            res[i][j] = now;
            now++;
        }
        for (; i < down; i++) {
            res[i][j] = now;
            now++;
        }
        for (; j > left; j--) {
            res[i][j] = now;
            now++;
        }
        for (; i > up; i--) {
            res[i][j] = now;
            now++;
        }

        // 下一层
        solver(res,now,left+1,right-1,up+1,down-1);
    }
    public static void main(String[] args){
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int n= 5;
        int[][] res =spiralMatrixII.generateMatrix(n);
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
