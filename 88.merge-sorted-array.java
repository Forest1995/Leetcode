/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (34.83%)
 * Total Accepted:    339.1K
 * Total Submissions: 966.9K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 思路：
 * 很简单，双指针分别指向尾部，一个指针指向 nums1 的最后
 * 然后依次比较，大的放到nums1的最后，然后移动指针
 * 如果 第二个数组还没扫到头，需要继续把它复制到第一个数组里
 * 如果 第一个数组没扫完，不用管，因为它本身就在对应的位置上
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = nums1.length-1;
        m--;
        n--;
        while (n >= 0 & m >= 0) {
            if (nums1[m] < nums2[n])
                nums1[pointer--] = nums2[n--];
            else
                nums1[pointer--] = nums1[m--];
        }
        while (n >= 0)
            nums1[pointer--] = nums2[n--];
    }
}
