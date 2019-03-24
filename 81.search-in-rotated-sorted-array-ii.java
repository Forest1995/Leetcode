import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (32.50%)
 * Total Accepted:    161.1K
 * Total Submissions: 495.8K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums
 * may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *  * 思路
 * 二分法改动一下
 * 因为旋转过，所以肯定有一半的数组是sorted
 * 所以先确定是那边的数组是sorted  因为有相等的元素，所以判断的时候不能加=号
 * 需要加上另外一半边是否 不是sorted的判断 的或集
 * 然后在判断target是否在sorted的那一半
 * 根据情况更新左右指针
 * 
 * 最后，如果两边都不是sorted，那么说明 nums[left]==nums[mid]==nums[right]
 * 那么就让right--，来继续搜索
 * 
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return true;
            else if (nums[left] < nums[mid] || nums[mid] > nums[right]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] < nums[right] || nums[mid] > nums[left]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else
                right--;
        }
        return false;
    }
}
