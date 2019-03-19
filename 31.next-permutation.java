/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.03%)
 * Total Accepted:    219.1K
 * Total Submissions: 727.8K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * 思路：
 * 双指针
 * 首先从后往前找，找到第一个递减的数字的位置i-1
 * 然后再从后往前找，找到第一个比它大的数字的位置j
 * 交换2个数字的位置
 * 然后从 i 位置开始reverse整个数组
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int i =nums.length-1;
        while (i>0 && nums[i]<=nums[i-1])
        i --;
        if(i >0)
        {
            int j = nums.length-1;
            while(j>=0&& nums[j]<=nums[i-1])
            j--;
            swap(i-1, j, nums);
        }
        reverse(nums,i);
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(left, right, nums);
            left++;
            right--;
        }
    }
}
