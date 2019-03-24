/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (53.81%)
 * Total Accepted:    434.8K
 * Total Submissions: 807.9K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * 思路：
 * 双指针：
 * 一个遍历数组，一个指向下一个非零数的位置
 * 如果遇到非零的数，则pointer交换
 * 优化：如果pointer和i相等，则没必要交换，
 * 只需要移动指针即可。
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != pointer) {
                    int temp = nums[i];
                    nums[i] = nums[pointer];
                    nums[pointer] = temp;
                }
                pointer++;
            }
        }
    }
}
