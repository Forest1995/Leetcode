/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (31.28%)
 * Total Accepted:    242.5K
 * Total Submissions: 770.9K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 思路：
 * 动态规划，从后往前进行循环
 * dp[i] 决定于 在 j=i+1 到 Nums[i]+i   的范围里是否有 true的点
 * 有的话则它为true
 * 否则为false
 * 最后判断dp[0]是否为true即可
 * 
 */
class Solution {
    public boolean canJump(int[] nums) {
        boolean []dp = new boolean [nums.length];
        dp[nums.length-1]=true;
        for(int i = nums.length-1;i>=0;i--){
            int furthestJump = Math.min(nums.length-1,nums[i]+i);
            for(int j = i+1; j<=furthestJump;j++){
                if (dp[j]==true){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0]==true;
    }
}

