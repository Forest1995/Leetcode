/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (40.11%)
 * Total Accepted:    205.4K
 * Total Submissions: 507.5K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 *  * 思路
 * 回溯
 * 先把数组排序，然后利用回溯找到所有可能性
 * 每次用target减去加进数组里的值
 * 当remain是0的时候，加入答案
 * 注意 因为有重复数字 需要加入避免重复的语句
 * 注意可以在forloop里加入条件限制 避免无用的分支
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    public void backtracking(List<List<Integer>> result, int[] candidates, int remain, List<Integer> temp, int index) {
        if (remain == 0) {
            result.add(new ArrayList(temp));
        }
        // else if(remain<0){
        // return ;
        // }
        else {
            for (int i = index; i < candidates.length && candidates[i] <= remain; i++) {
                if (i > index && candidates[i] == candidates[i - 1])  //不是第一个 && 和前一个相等， 跳过
                    continue;
                temp.add(candidates[i]);
                backtracking(result, candidates, remain - candidates[i], temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
