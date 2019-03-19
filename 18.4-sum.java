import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (29.67%)
 * Total Accepted:    217K
 * Total Submissions: 725.9K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 思路:
 * 和3sum一样，相当于多一个loop的3sum
 * 多一个指针而已
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > (i+1 )&& nums[j] == nums[j - 1])
                    continue;
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while (m < n && nums[m] == nums[m + 1])
                            m++;
                        while (m < n && nums[n] == nums[n - 1])
                            n--;
                        m++;
                        n--;
                    } else if (sum < target)
                        m++;
                    else
                        n--;
                }
            }
        }
        return result;
    }
}
