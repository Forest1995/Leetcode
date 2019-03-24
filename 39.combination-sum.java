import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (46.64%)
 * Total Accepted:    313.5K
 * Total Submissions: 665.7K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
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
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 思路
 * 回溯
 * 先把数组排序，然后利用回溯找到所有可能性
 * 每次用target减去加进数组里的值
 * 当remain是0的时候，加入答案
 * 注意可以在forloop里加入条件限制 避免无用的分支
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List <List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(result, candidates, target, new ArrayList<>(),0);
        return result;
    }
    public void backtracking(List <List<Integer>> result, int[] candidates, int remain, List<Integer> temp, int index ){
        if(remain==0){
            result.add(new ArrayList(temp));
        }
        // else if(remain<0){
        //     return ;
        // }
        else{
            for(int i =index; i < candidates.length && candidates[i]<=remain; i++){
                temp.add(candidates[i]);
                backtracking(result, candidates, remain-candidates[i], temp, i);
                temp.remove(temp.size()-1);
            }
        }
    }
}

