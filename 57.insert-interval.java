import java.util.ArrayList;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 *
 * https://leetcode.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (30.72%)
 * Total Accepted:    167.3K
 * Total Submissions: 542.1K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with
 * [3,5],[6,7],[8,10].
 * 
 */
/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 * 
 * 思路
 * 1.先找到 在新加入的interval之前的 interval 加入result 判断条件是 interval.end<newinterval.start
 * 2.找到与 newinterval 可以融合的interval 判断条件是interval.start <= newinterval.end 
 * 融合时取 两者小的start作为start 两者大的end作为end
 * 3.最后把剩下的interval加进去即可
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int size = intervals.size();
        int i = 0;
        while (i < size && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i++));
        }
        while (i < size && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end));
                    i++;
        }
        result.add(newInterval);
        while(i<size)
            result.add(intervals.get(i++));
        return result;
    }
}
