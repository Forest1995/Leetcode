import com.sun.prism.impl.Disposer.Target;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (40.49%)
 * Total Accepted:    297.9K
 * Total Submissions: 715.7K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 思路：
 * 将数组排序
 * 然后利用2sum排序版的方法，
 * 确定第一个指针p后，后两个指针分别指向p+1和数组的尾部
 * 然后与target进行比较，如果相等则直接返回target，不等则更新指针
 * 然后通过比较    result-target   和     sum-target  的绝对值来判断最接近的一组数
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;

                if (sum < target)
                    j++;
                else
                    k--;
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }
}
