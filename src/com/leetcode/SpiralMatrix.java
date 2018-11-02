package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/10/29 9:54
 */
/***
 * 题目来源： https://leetcode.com/problems/spiral-matrix/
 * 时间复杂度 O(N) N=row*col 为matrix中所有元素的个数 空间复杂度 O(N)
 * 思路：递归求解 每次都处理最外围的一圈
 * 解：分四个方位，进行游走，右下左上 ，一次最外圈处理完后缩小矩阵大小 ，进行下一次递归，
 * 递归结束条件-上下左右边界无法构成矩阵
 * →→→→→
 * ↑→→→↓
 * ↑↑→↓↓
 * ↑←←↓↓
 * ←←←←↓
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        solver(res, matrix, 0, matrix[0].length-1,0,matrix.length-1 );
        return res;
    }

    private void solver(List<Integer> res, int[][] matrix, int left, int right, int up, int down) {
        if(left>right || up >down){
            return;
        }
        // 上下左右四个边界
        // 右
        int i = up;
        int j =left;
        while(j<=right){
            res.add(matrix[i][j]);
            j++;
        }
        // 下
        i=up+1;
        j=right;
        while(i<=down){
            res.add(matrix[i][j]);
            i++;
        }
        if(left!=right&&up!=down){
            // 至少是个2*2矩阵
            // 左
            i=down;
            j=right-1;
            while(j>=left){
                res.add(matrix[i][j]);
                j--;
            }
            // 上
            i=down-1;
            j=left;
            while(i>up){
                res.add(matrix[i][j]);
                i--;
            }
        }
        solver(res,matrix,left+1,right-1,up+1,down-1);
    }
    public static void main(String[] args){
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix ={

        };
//        int[][] matrix ={
//                {1,2,3,4,5},
//                {1,2,3,4,5},
//                {1,2,3,4,5},
//                {1,2,3,4,5},
//                {1,2,3,4,5},
//        };
//        int[][] matrix ={
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12}
//        };
        System.out.println(spiralMatrix.spiralOrder(matrix));
        System.out.println(spiralMatrix.spiralOrder(matrix).size());
    }
}
