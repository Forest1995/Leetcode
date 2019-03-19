/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.53%)
 * Total Accepted:    390.3K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 思路把2个数组merge成一个数组
 * 然后根据这个数组的奇偶长度判断返回值是中间那个
 * 还是中间2个平均值
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] > nums2[p2]) {
                result[p++] = nums2[p2++];
            } else {
                result[p++] = nums1[p1++];
            }
        }
        while (p1 < m) {
            result[p++] = nums1[p1++];
        }
        while (p2 < n) {
            result[p++] = nums2[p2++];
        }
        int x = m + n;
        if ((x & 1) == 0) {
            int mid = x / 2 - 1;
            return (double) (result[mid] + result[mid + 1]) / 2;
        } else {
            int mid = x / 2;
            return (double) result[mid];
        }
    }
}
