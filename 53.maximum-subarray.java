/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (42.76%)
 * Total Accepted:    480.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 思路
 * 扫一遍数组
 * 因为要连续的，所以可以找以每个位置为结束点的最大值，要不是 自己加之前位置的和 ，那么就是 自己
 * 同时更新目前为止的最大值
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0] ;
        int maxEndingHere= nums[0];
        for(int i =1 ; i< nums.length;i++){
            maxEndingHere=Math.max(nums[i],nums[i]+maxEndingHere);
            maxSoFar=Math.max(maxEndingHere,maxSoFar);
        }
        return maxSoFar;
    }
}

