package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/18 14:20
 */
/***
 * 题目来源： https://leetcode.com/problems/rotate-image/
 * 时间复杂度 O(n^2) n*n矩阵 空间复杂度 O(1)
 * 思路：将四个点看做一组 每次交换一组点的位置；
 *
 * 如
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 *解 ： 对于点 1(0,0) 交换它所对应的组的四个点 1(0,0) , 4(0,3) , 16(3,4), 13(3,0)
 * 根据点(i,j)和标记mark=n-1可以计算它变换的下一个位置(j,mark-i)
 * 再根据变换的下一个位置计算下下个位置 可以得到四个点的坐标，交换之；
 */
public class RotateImage {
    /**
     * @param matrix n*n
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 对称中心点的两倍 中心点 ->（mark/2.0,mark/2.0）
        int mark = n - 1;
        int row = 0;
        while (2 * row <= mark) {
            for (int col = row; col <= n - 2 - row; col++) {
                // 四值交换位置 ；
                change(matrix, row, col, mark);
            }
            row++;
        }
    }

    private void change(int[][] matrix, int i, int j, int mark) {
        int i1 = j;
        int j1 = mark - i;
        int i2 = j1;
        int j2 = mark - i1;
        int i3 = j2;
        int j3 = mark - i2;
        int temp = matrix[i3][j3];
        matrix[i3][j3] = matrix[i2][j2];
        matrix[i2][j2] = matrix[i1][j1];
        matrix[i1][j1] = matrix[i][j];
        matrix[i][j] = temp;
    }
    public static void main(String[] args){
        RotateImage rotateImage = new RotateImage();
        int[][] matrix ={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotateImage.rotate(matrix);
        System.out.println(matrix);
        for(int i =0;i<matrix.length;i++){
            for(int j =0 ;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
