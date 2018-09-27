package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/27 9:54
 */
/***
 * 题目来源： https://leetcode.com/problems/swap-nodes-in-pairs/
 * 时间复杂度 O(logn)  n-->The depth of ListNode
 * 思路：利用多指针遍历链表
 * 解：先构建一个假节点作为头节点 ， 保证first 领先 second 两个位移
 * 当first指针不为null时，交换节点的位置 first和second指针尝试往下两个位移
 * 当first指针等于null时，说明已经走到链表的尾节点之后，遍历结束，所有可交换ListNode-pairs都已经交换
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode second = dummy;
        ListNode first = head.next;
        ListNode temp;
        ListNode next;
        while (first != null) {
            //  swap Node 0->1->2->3->4 <--after swap--> 0->2->1->3->4
            temp = second.next;
            next = first.next;
            second.next = first;
            first.next = temp;
            temp.next = next;
            first = temp;

            // go one step (1/2)
            first=first.next;
            second=second.next;
            if (first!=null){
                // go another one step (2/2)
                first=first.next;
                second=second.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode res = swapNodesInPairs.swapPairs(l1);
        System.out.println(res);
    }
}
