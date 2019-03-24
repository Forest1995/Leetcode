/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (34.39%)
 * Total Accepted:    166.3K
 * Total Submissions: 483.7K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example: 
 * 
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution of
 * which the time complexity is O(n log n). 
 * 
 * 思路
 * 双指针：像一个窗户一样，一个在前，一个在后，两者的差值为最小长度
 * 记录这个窗户里的求和数值，一旦大于 s  则计算其长度，
 * 并将左边的窗户缩小，相当于把左边的指针的位置那个数从 求和 中减掉，并让指针加1
 * 
 * 这里用while 不是if，因为加入的第i个值可能非常大，我们可能只需要它一个就大于s，
 * 所以用while持续判断，如果确实大于则继续移动左边指针
 * 最后返回记录的最小长度
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sumEndinghere = 0;
        int p1 = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sumEndinghere += nums[i];
            while (sumEndinghere >= s) {
                minLen = Math.min(minLen, i - p1 + 1);
                sumEndinghere -= nums[p1];
                p1++;
            }
        }
        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }
}
