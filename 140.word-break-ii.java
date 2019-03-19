import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (26.63%)
 * Total Accepted:    148.9K
 * Total Submissions: 557.3K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 * 思路 ：
 * 第一想法是用backtrack来找到所有可能的情况
 * 然后一一比较有没有正确的组合。但是超时了，
 * 所以需要用空间换时间
 * 需要记住之前成功的组合，所以用Hashmap来记住substring的result
 * 用string的startwith将s分成左右两部分，右边进行递归之后
 * 将结果与左边相加，然后输出
 * 如果没找到说明右边返回值是空集，那么加不了，所以最终返回值也是空集
 * 
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtracking(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> backtracking(String s, List<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new LinkedList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                if (next.length() == 0)
                    result.add(word);
                else {
                    List<String> subresult = backtracking(next, wordDict, map);
                    for (String subwords : subresult) {
                        result.add(word + " " + subwords);
                    }
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
