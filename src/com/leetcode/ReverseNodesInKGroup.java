package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/27 10:48
 */
/***
 * 题目来源： https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 时间复杂度 o(k*n)
 * 思路：每次尝试走k个位移，成功则将走过的k个节点reverse,失败则说明走过的节点个数不满足k个所以不变动
 * 解：
 * 先定义一个假节点作为头节点
 * 每次尝试走k个位移，
 * 1->成功则将走过的k个节点reverse,
 * 2->失败则说明走过的节点个数不满足k个所以不变动
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode[] listNodes = new ListNode[k];
        ListNode current = dummy;
        ListNode last = dummy;
        while (current != null && current.next != null) {
            for (int i = 0; i < k; i++) {
                if (current.next != null) {
                    current = current.next;
                    listNodes[i] = current;
                } else {
                    current = null;
                    break;
                }
            }
            if (current != null) {
                ListNode temp = current.next;
                for (int j = k - 1; j >= 1; j--) {
                    listNodes[j].next = listNodes[j - 1];
                }
                last.next = listNodes[k - 1];
                listNodes[0].next = temp;
                current = listNodes[0];
                last = current;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        int n = 5;
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode res = reverseNodesInKGroup.reverseKGroup(l1, n);
        System.out.println(res);
    }
}
