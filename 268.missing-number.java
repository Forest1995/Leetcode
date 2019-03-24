/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (47.74%)
 * Total Accepted:    254.9K
 * Total Submissions: 533.8K
 * Testcase Example:  '[3,0,1]'
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,0,1]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * 
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 * 
 * 思路1：
 * bit operation:
 * index 0 - n-1
 * value 0 - n 少其中某一个
 * 
 * 所以只要多加一个 n 在index 那边变成
 * index 0 - n
 * value 0 - n 少其中某一个
 * XOR之后就能找到缺少的哪一个
 * 
 * 思路2：
 * 找到 0-n 的sum  然后减去每一个value，剩下的便是缺少的那个
 * 
 */
class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
            result ^= i;
        }
        return result;
    }
}
