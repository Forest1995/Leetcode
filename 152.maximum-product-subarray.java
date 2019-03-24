/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (28.52%)
 * Total Accepted:    195K
 * Total Submissions: 679.3K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * 思路：
 * 与 max sum subarray类似
 * 记录以当前位置为终点的最大和最小乘积
 * 当遇到负数时，将2个值交换，因为乘一个负数使最大数变最小，使最小变最大
 * multiplied by a negative makes big number smaller, small number bigger
 * 然后遍历数组，更新最大最小乘积的同时，
 * 更新题目要的结果 最大值
 * 
 *
 * 这道题妙就妙在它不仅仅依赖了一个状态（前一个数所能获得的最大乘积），而是两个状态（最大和最小乘积）。
 * 比较简单的dp问题可能就只是会建立一个dp[]，
 * 然后把最大值放到其中。但是这道题给我们打开了新的思路：
 * 我们的dp数组里面可以存更多的信息。
 * 而上面的解法之所以没有用dp数组的原因是dp[i]只依赖于dp[i - 1]因此没有必要把前面所有的信息都存起来，
 * 只需要存前一个dp[i-1]的最大和最小的乘积就可以了。
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int result = nums[0];
        for(int i = 1 ;i< nums.length;i++){
            int curVal = nums[i];
            if(curVal < 0 ){
                int temp = maxEndingHere ;
                maxEndingHere = minEndingHere;
                minEndingHere= temp;
            }
            maxEndingHere = Math.max(curVal, curVal*maxEndingHere);
            minEndingHere = Math.min(curVal, curVal*minEndingHere);
            result = Math.max(maxEndingHere,result);
        }
        return result;
    }
}
