package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/26 10:32
 */
/***
 * 题目来源： https://leetcode.com/problems/merge-two-sorted-lists/
 * 时间复杂度 o(n + m)
 * 思路：遍历两链表
 * 解：没有难度 一步步来即可 解见代码 (唯一一点方便之处，构造出一个假的头节点)
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 构造出一个假的头节点
        ListNode dump = new ListNode(0);
        ListNode p = dump;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                // not  not
                if (l1.val < l2.val) {
                    p.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    p.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            } else if (l1 == null) {
                // null not
                p.next =new ListNode(l2.val);
                l2=l2.next;
            } else {
                // not null
                p.next =new ListNode(l1.val);
                l1=l1.next;
            }
            p=p.next;
        }
        return dump.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(10);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(5);
        ListNode r4 = new ListNode(7);
        ListNode r5 = new ListNode(9);
        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        r4.next=r5;
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode res = mergeTwoSortedLists.mergeTwoLists(l1,r1);
        System.out.println(res.toString());
    }
}
