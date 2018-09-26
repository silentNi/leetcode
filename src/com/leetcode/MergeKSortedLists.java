package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/9/26 16:22
 */
/***
 * 题目来源： https://leetcode.com/problems/merge-k-sorted-lists/solution/
 * 时间复杂度 O(kn)
 * 思路：将ListNode数组中所有节点的值取出来，进行排序，最后生成一个新的链表
 * 解：同思路 没有特别要注意的地方
 * 另解思路：
 * 1. 利用MergeTwoSortedLists方法，俩俩合并 n -->  n/2 --> n/4 --> ...--> 1
 * 2. 优先队列 将节点放入队列时就进行排序，之后只需要往外就可以了 ，算是我这个解法（路子有点野）的进阶版本。
 * 3. 一一比较 对n个节点的有效值都进行比较，选出最小值
 *
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(0);
        ListNode res =root;
        List<Integer> nums = new ArrayList<>();
        for (ListNode node :lists){
            ListNode temp =node;
            while(temp!=null){
                nums.add(temp.val);
                temp=temp.next;
            }
        }
        int[] all = new int[nums.size()];
        int i=0;
        for(Integer integer : nums){
            all[i++]=integer;
        }
        Arrays.sort(all);
        for (int k =0 ;k<all.length;k++){
            res.next = new ListNode(all[k]);
            res =res.next;
        }
        return root.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(7);
        ListNode l4 = new ListNode(10);
        ListNode l5 = new ListNode(13);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        ListNode r1 = new ListNode(2);
        ListNode r2 = new ListNode(5);
        ListNode r3 = new ListNode(8);
        ListNode r4 = new ListNode(11);
        ListNode r5 = new ListNode(14);
        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        r4.next=r5;

        ListNode t1 = new ListNode(3);
        ListNode t2 = new ListNode(6);
        ListNode t3 = new ListNode(9);
        ListNode t4 = new ListNode(12);
        ListNode t5 = new ListNode(15);
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        ListNode[] lists = new ListNode[3];
        lists[0]=l1;
        lists[1]=r1;
        lists[2]=t1;
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode ans = mergeKSortedLists.mergeKLists(lists);
        System.out.println(ans);
    }
}
