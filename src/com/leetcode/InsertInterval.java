package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/5 11:31
 */
/***
 * 题目来源： https://leetcode.com/problems/insert-interval/
 * 时间复杂度 O(N) 遍历  空间复杂度 O(N) 最坏O(N) 最好O(1)
 * 思路：考虑合并区间的各种情况
 * 解：
 * 之后对列表进行遍历，将有重叠部分的区间进行合并（只有两种情况下两个区间才不重叠，其余都会重叠），
 * 没有就加入解的列表 ，记录newInterval应该插入的位置
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i=0;
        for(Interval now : intervals){
            if(now.end<newInterval.start){
                res.add(now);
                i++;
            }else if(now.start>newInterval.end){
                res.add(now);
            }else{
                newInterval.start = Math.min(now.start,newInterval.start);
                newInterval.end = Math.max(now.end,newInterval.end);
            }
        }
        res.add(i,newInterval);
        return res;
    }
    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(3, 4));
        intervals.add(new Interval(0, 0));
//        intervals.add(new Interval(13, 15));
//        Interval newInterval = new Interval(4,5);
        Interval newInterval = new Interval(1,4);
        List<Interval> res= insertInterval.insert(intervals,newInterval);
        for (Interval now : res) {
            System.out.println(now.toString());
        }

    }
}
