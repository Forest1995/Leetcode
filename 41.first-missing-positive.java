/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (28.20%)
 * Total Accepted:    196.4K
 * Total Submissions: 692.5K
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array, find the smallest missing positive
 * integer.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,0]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,4,-1,1]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [7,8,9,11,12]
 * Output: 1
 * 
 * 
 * Note:
 * 
 * Your algorithm should run in O(n) time and uses constant extra space.
 * 对于这种要求空间复杂度的，我们可以先考虑如果有一个等大的空间，我们可以怎么做。
 * 然后再考虑如果直接用原数组怎么做，主要是要保证数组的信息不要丢失。
 * 目前遇到的，主要有两种方法就是交换和取相反数。
 * 
 * 思路：
 * 首先将正数移动到数组的前端，并得到正数的个数
 * 然后得到要标记的下标位置
 * 如果下标位置大于等于k，忽略
 * 小于k，将那个位置的数标记为负数
 * 最后寻找第一个大于0的位置，这个位置+1就是第一个缺失的正数
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int k = positiveNumber(nums);
        for(int i =0;i<k ;i++){
            int index = Math.abs(nums[i])-1;
            if(index<k){
                int temp = nums[index];
                nums[index] = temp<0 ? temp : -temp;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return k+1;
    }

    public int positiveNumber(int[] nums){
        int p = 0;
        for (int i = 0;i <nums.length;i++){
            if(nums[i]>0){
                swap(nums, i, p);
                p++;
            }
        }
        return p;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}










    //     int n = nums.length;
    //     //将正数移到前边，并且得到正数的个数
    //     int k = positiveNumber(nums);
    //     for (int i = 0; i < k; i++) {
    //         //得到要标记的下标
    //         int index = Math.abs(nums[i]) - 1;
    //         if (index < k) {
    //             //判断要标记的位置的数是不是小于 0，不是小于 0 就取相反数
    //             int temp = nums[index];
    //             nums[index] = temp < 0 ? temp : -temp;//因为有可能有同样的数字，因此一个位置可能被反好几次
    //         }
    //     }
    //     //找到第一个大于 0 的位置
    //     for (int i = 0; i < k; i++) {
    //         if (nums[i] > 0) {
    //             return i + 1;
    //         }
    //     }
    //     return k + 1;
    // }
    
    // private int positiveNumber(int[] nums) {
    //     //解法一 把负数和 0 全部交换到最后
    //     /*    int n = nums.length;
    //     for (int i = 0; i < n; i++) {
    //         while (nums[i] <= 0) {
    //             swap(nums, i, n - 1);
    //             n--;
    //             if (i == n) {
    //                 break;
    //             }
    //         }
    //     }
    //     return n;*/
    
    //     //解法二 用一个指针 p ，保证 p 之前的都是正数。遍历 nums，每遇到一个正数就把它交换到 p 指针的位置，并且 p 指针后移
    //     int n = nums.length;
    //     int p = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (nums[i] > 0) {
    //             swap(nums, i, p);
    //             p++;
    //         }
    //     }
    //     return p;
    
    // }
    


