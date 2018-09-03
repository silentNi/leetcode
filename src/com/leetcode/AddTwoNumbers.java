package com.leetcode;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/3 11:29
 */

/***
 * 题目来源： https://leetcode.com/problems/add-two-numbers/description/
 * 时间复杂度o( max(n,m) )
 * 思路：遍历节点 节点的数值相加 逢十进一 注意最后只有进位的情况
 * 解：给定俩节点p , q
 * 当节点不为null时，数值为有效数值，否则为0 数值相加，进位向上传 ；节点往下走
 * 当p，q都为null后结束while循环
 * 判断是否有进位
 *
 */

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode root =res;
        int more = 0;
        int ans = 0;
        int val1=0;
        int val2=0;
        while (l1 != null || l2 != null ) {
            if(l1==null){
                val1=0;
            }else{
                val1=l1.val;
                l1=l1.next;
            }
            if(l2==null){
                val2=0;
            }else{
                val2=l2.val;
                l2=l2.next;
            }
            ans = val1 + val2 + more;
            more = ans / 10;
            ans = ans % 10;
            ListNode node = new ListNode(ans);
            res.next =node;
            res =res.next;
        }
        if( more==1){
            ListNode node = new ListNode(more);
            res.next =node;
        }
        return root.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers= new AddTwoNumbers();
//        ListNode l1 = new ListNode(2);
//        ListNode a2 = new ListNode(4);
//        ListNode a3 = new ListNode(3);
//        a2.next=a3;
//        l1.next=a2;
//        ListNode l2 = new ListNode(5);
//        ListNode b2 = new ListNode(6);
//        ListNode b3 = new ListNode(4);
//        b2.next=b3;
//        l2.next=b2;
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l2.next=l3;
//        ListNode l1 = new ListNode(0);
        ListNode res =addTwoNumbers.addTwoNumbers(l1,l2);
        System.out.println(res);
    }

}
