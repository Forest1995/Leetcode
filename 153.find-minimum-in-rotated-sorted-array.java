import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (42.45%)
 * Total Accepted:    265.5K
 * Total Submissions: 623.3K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * 思路：
 * Binary search
 * 1. loop is left < right, which means inside the loop, left always < right
 * 
(2) since we use round up for mid, and left < right from (1), right would never be the same as mid

(3) Therefore, we compare mid with right, since they will never be the same from (2)

(4) if nums[mid] < nums[right], we will know the minimum should be in the left part, so we are moving right.
We can always make right = mid while we don't have to worry the loop will not ends. 
from (2), we know right would never be the same as mid, making right = mid will assure the interval is shrinking.

(5) if nums[mid] > nums[right], minimum should be in the right part, 
so we are moving left. Since nums[mid] > nums[right],mid can't be the minimum, 
we can safely move left to mid + 1, which also assure the interval is shrinking
 * 
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else if (nums[mid] < nums[right])
                right = mid;
            else if (nums[mid] > nums[right])
                left = mid + 1;
        }
        return nums[left];
    }
}
