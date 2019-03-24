import java.util.Arrays;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (51.46%)
 * Total Accepted:    357.7K
 * Total Submissions: 690.7K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 思路1：
 * 排序后返回中间那个数
 * 思路2：
 * 
 * 摩尔投票法
 * 将每2个不同的元素都 删除， 最后剩下的肯定是marjority
 */
class Solution {
    public int majorityElement(int[] nums) {
        int majorNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majorNum = nums[i];
                count = 1;
            } else if (majorNum == nums[i])
                count++;
            else
                count--;
        }
        return majorNum;
    }
}
// Arrays.sort(nums);
// int mid = (nums.length-1)/2;
// return nums[mid];
// }
// }
