package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/25 15:42
 */
/***
 * 题目来源： https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 时间复杂度 o(n) 与ListNode的长度有关
 * 思路：多指针记录 最后 p1指向要替换的值前一个节点 p2指向要替换的值的节点 q指向尾指针
 * 解：初始先设置好各个指针之间的距离，统一往前走直到q指针走到尾
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // q指针领先p1指针n个节点 p1->p2->....->q
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode q = p1;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        if (q == null) {
            if (n == 1) {
                return null;
            } else {
                return p1.next;
            }
        }
        while (q.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            q = q.next;
        }
        // q -> 尾节点
        p1.next = p2.next;

        return head;
    }
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        int n=5;
//        ListNode l1 = new ListNode(0);
        ListNode res =removeNthNodeFromEndOfList.removeNthFromEnd(l1,n);
        System.out.println(res);
    }
}
