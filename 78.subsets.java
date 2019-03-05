import java.util.ArrayList;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (50.92%)
 * Total Accepted:    331.8K
 * Total Submissions: 650.3K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 思路：
 * 最简单的回溯：1 停止条件是index大于等于数组长度(其实不加都可以)
 * 穷尽所有的可能性
 * 回溯记得在最后删除掉之前加的元素
 * 加list要用新的 new arraylist <>(temp)
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    private void backtracking(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int index) {
        result.add(new ArrayList<>(temp));
        // if (index >= nums.length)
        //     return;
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
