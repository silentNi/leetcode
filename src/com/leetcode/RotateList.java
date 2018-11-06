package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/6 11:31
 */
/***
 * 题目来源： https://leetcode.com/problems/rotate-list/
 * 时间复杂度 O(N) N is the length of head 空间复杂度 O(N)
 * 思路：双指针遍历链表 ，
 * 解：遍历一次链表--> 至少可得一项数据 ：1. 链表长度（len<=k） or 2. 两指针间距k （ len>k ）
 * 使两指针间距的（k%len）距离 ，双指针一同往前走 ，直到最后一个元素，利用双指针和头节点变换链表得到变换后的链表；
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // 记录链表长度 防止k过大
        ListNode dummy = new ListNode(0);
        ListNode p = head;
        ListNode q = head;

        int len = 1;
        while (q.next != null && len <= k) {
            len++;
            q = q.next;
        }
        if (q.next == null) {
            k = k % len;
            // k < len
            if(k==0){
                return head;
            }
            int count = 0;
            p = head;
            q = head;
            while (count < k) {
                count++;
                q = q.next;
            }
        }
        //  q - p == k
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        dummy.next = p.next;
        q.next = head;
        p.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        int k = 6;
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode res = rotateList.rotateRight(head, k);
        System.out.println(rotateList.rotateRight(head, k));
    }
}
