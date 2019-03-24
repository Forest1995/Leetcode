import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (40.86%)
 * Total Accepted:    194.8K
 * Total Submissions: 474.2K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * 
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 思路：
 * 将所有元素存到一个set里 以便提供O(1)的查询时间
 * 然后遍历数组，用while loop来找到最长的连续数字
 * 加一个判断条件来提高效率，如果 当前数字-1不在set里面的话，说明当前数字是一个新的起点，可以开始计算
 * 否则，当前数字是 别的数字作为起点的一部分，不用考虑
 * 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        int result = 0 ;
        for (int num : nums)
            map.add(num);
        for(int num: nums){
            if(!map.contains(num-1)){
                int count = 1;
                int number =num+1;
                while(map.contains(number)){
                    count++;
                    number++;
                }
                result=Math.max(result,count);
            }
        }
        return result;
    }
}
