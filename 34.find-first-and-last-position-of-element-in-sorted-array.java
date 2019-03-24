/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (32.96%)
 * Total Accepted:    274.9K
 * Total Submissions: 830.9K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 思路：
 * 目的是找到第一个相等的
 * 这题的二分法 右边改成 nums.length
 * 找到相等的也不返回，继续让右边等于mid
 * 
 * 找最后一个相等的话 用将target+1作为参数传入，
 * 最后将找到的index-1即可
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res1 =binarySearchLeft(nums, target);
        if(res1 == nums.length || nums[res1] != target){
            return new int []{-1,-1};
        }
        return new int []{res1,binarySearchLeft(nums, target+1)-1};
    }
    public int binarySearchLeft(int[] nums, int target){
        int left = 0 ;
        int right = nums.length;
        while(left<right){
            int mid = left + (right - left) /2;
            if(target<=nums [mid]){
                right = mid;
            }
            else{
                left=mid+1;
            }
        }    
        return left;
    }

}

