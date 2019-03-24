/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/description/
 *
 * algorithms
 * Medium (40.71%)
 * Total Accepted:    223K
 * Total Submissions: 545.5K
 * Testcase Example:  '[1,2,3,1]'
 *
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element
 * and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5 
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2, 
 * or index number 5 where the peak element is 6.
 * 
 * 
 * Note:
 * 
 * Your solution should be in logarithmic complexity.
 * 
 * 思路1：
 * 遍历数组
 * 找到第一个前一个比后一个数大的值返回即可
 * 
 * 
 * 思路2
 * 二分查找
 * while 左小于右
 * 判断一下中间 和中间 +1 的大小，来判断走向
 * 如果 中间小于中间+1 那么说明右边有peak 让 左边等于 mid+1
 * 否则左边有peak 让右边等于mid
 * 最后返回左边即可
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
// for (int i = 1; i < nums.length; i++) {
// if (nums[i - 1] > nums[i])
// return i - 1;
// }
// return nums.length - 1;
// }
// }
