/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (41.29%)
 * Total Accepted:    298.1K
 * Total Submissions: 718K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 思路1
 * 实现quicksort
 * 如果low不再小于high
   1.partition
 * 每次找到数组最后一个数，把比它小的放左边，大的放右边
 * 然后把它放到中间正确的位置
 * 2.递归
 * 之后进行递归 low to p-1 和 p+1 to high
 * 
 * 思路2
 * 双指针 p0 和 p2
 * 扫一遍数组，while遇到0并且当前位置大于p0的话，和p0交换 p0++
 * while遇到2并且当前位置小于p2的话，和p2交换 p2--
 * 
 * 遇到1不管
 */
class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);
            quickSort(nums, low, p - 1);
            quickSort(nums, p + 1, high);
        }
    }
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for(int j = low ;j<high;j++){
            if(nums[j]<pivot){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,high);
        return i;
    }
    public void swap (int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
