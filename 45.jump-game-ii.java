/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (27.44%)
 * Total Accepted:    158K
 * Total Submissions: 571.6K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * ⁠   Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 * 思路：
 * 贪心算法
 * 记录当前位置 可以跳的最远距离
 * 在这个范围内，选一个可以跳的最远的距离的点跳
 * 做法
 * 当当前位置 和 之前记录的 最远距离 相等时，必须要再跳一次 jump++，但不一定时在当前位置跳 
 * 同时把最远距离更新
 */
class Solution {
    public int jump(int[] nums) {
        int curEnd = 0 ;
        int curFurthest = 0;
        int jumps = 0;
        for(int i=0;i<nums.length-1;i++){
            curFurthest = Math.max(curFurthest,nums[i]+i);
            if(i==curEnd){
                curEnd=curFurthest;
                jumps++;
            }
        }
        return jumps;
    }
}

