package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/2 10:30
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
/***
 * 题目来源： https://leetcode.com/problems/merge-intervals/
 * 时间复杂度 O(NlogN+N) 排序+遍历  空间复杂度 O(N) 最坏O(N) 最好O(1)
 * 思路：排序后遍历
 * 解：先对列表进行排序，指定排序规则，满足三个性质（传递性、自反性和对称性）,
 * 之后对列表进行遍历，将有重叠部分的区间进行合并，没有就加入解的列表
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        Interval last = new Interval();
        boolean first = false;
        List<Interval> res = new ArrayList<>();
        /**
         *
         在JDK7以后，实现Comparable接口后，要满足一下三个特性：
         1） 自反性：x，y 的比较结果和 y，x 的比较结果相反。
         2） 传递性：x>y,y>z,则 x>z。
         3） 对称性：x=y,则 x,z 比较结果和 y，z 比较结果相同。
         */
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });


        for (Interval now : intervals) {
            if (!first) {
                last = now;
                first = true;
                continue;
            }
            if (last.end >= now.start) {
                last.end = Math.max(last.end,now.end);
            } else {
                res.add(last);
                last = now;
            }
        }
        res.add(last);
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> res = mergeIntervals.merge(intervals);
        for (Interval now : res) {
            System.out.println(now.toString());
        }
    }
}
