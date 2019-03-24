/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (35.40%)
 * Total Accepted:    126.2K
 * Total Submissions: 356.5K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * 
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 * 
 * 思路
 * 首先记录当前的位置index 作为起始点，
 * while判断其下个位置的数是否比当前大1，是的话i++
 * 如果 i有变动，说明有连续的范围，则输出箭头模式
 * 如果i没变过，说明是独立的点，则输出单个数字
 * 
 * 注意加入string的方式，直接add(""+数字即可)
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (nums[i] != nums[start]) {
                result.add(nums[start] + "->" + nums[i]);
            } else
                result.add(nums[start] + "");
        }
        return result;
    }
}
