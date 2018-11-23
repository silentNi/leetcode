package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/22 16:52
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/***
 * 题目来源： https://leetcode.com/problems/unique-binary-search-trees-ii/
 * 时间复杂度 O(4^n / (n^(1/2))) 空间复杂度  O(4^n / (n^(1/2))) ， 和卡特兰数的增加速度O( 4^n /(n^(3/2) * π^(1/2)))有关
 * 思路：分治，分为左右子树来生成结果
 * 解：利用二叉搜索树的性质
 * 对于一个连续的数序列，选择一个数作为根节点，
 * 他的左子树由比他小的所有数构成，他的右子树由比他大的所有数构成，
 * 比如 数序列 (1,2,3,4,5) 选择 2 作为根节点，左子树由(1),右子树由(3,4,5)构成，左右子树也可由此方法生成
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
//        List<TreeNode> res = generateTreeNodeList(1,n);
        return  generateTreeNodeList(1,n);
    }

    /**
     * 想到的解法竟然和最快的算法一样
     *  根据数序列(start,start+1,...,end)生成所有可能的二叉搜索树
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> generateTreeNodeList(int start, int end) {
        if (start > end) {
            List<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTreeNodeList(start,i-1);
            List<TreeNode> right = generateTreeNodeList(i+1,end);
            for(TreeNode leftNode:left){
                for(TreeNode rightNode:right){
                    TreeNode node = new TreeNode(i);
                    node.left =leftNode;
                    node.right =rightNode;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public List<TreeNode> generateTrees2(int n) {
        // 递归回溯 FIXME 会有重复解
        List<TreeNode> res = new ArrayList<>();
        TreeNode dummy = new TreeNode(-1);
        boolean[] visited = new boolean[n + 1];
        solver(res, dummy, visited, 0, 1, n);
        return res;
    }

    private void solver(List<TreeNode> res, TreeNode dummy, boolean[] visited, int count, int now, int n) {
        if (count == n) {
            TreeNode copyNode = copy(dummy.left);
            res.add(copyNode);
            return;
        }
        for (int tmp = now; tmp < now + n; tmp++) {
            int i = tmp <= n ? tmp : tmp - n;
            if (visited[i]) {
                continue;
            }
            TreeNode changeNode = findChangeNode(dummy, i);
            if (changeNode == dummy) {
                changeNode.left = new TreeNode(i);
            } else {
                if (changeNode.val > i) {
                    changeNode.left = new TreeNode(i);
                } else {
                    changeNode.right = new TreeNode(i);
                }
            }
            visited[i] = true;
            solver(res, dummy, visited, count + 1, i + 1, n);
            visited[i] = false;
            if (changeNode == dummy) {
                changeNode.left = null;
            } else {
                if (changeNode.val > i) {
                    changeNode.left = null;
                } else {
                    changeNode.right = null;
                }
            }
        }

    }

    private TreeNode findChangeNode(TreeNode node, int i) {
        TreeNode res = node.left;
        TreeNode pre = node;
        while (res != null) {
            if (res.val > i) {
                pre = res;
                res = res.left;
            } else {
                pre = res;
                res = res.right;
            }
        }
        return pre;
    }

    private TreeNode copy(TreeNode node) {
        // 复制节点
        if (node == null) {
            return null;
        }
        TreeNode tmp = new TreeNode(node.val);
        tmp.left = copy(node.left);
        tmp.right = copy(node.right);
        return tmp;
    }

    public static void main(String... args) {
        UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
        System.out.println(u.generateTrees(1).size());
    }
}
