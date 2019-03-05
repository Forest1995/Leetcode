import java.util.HashSet;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (27.93%)
 * Total Accepted:    811.1K
 * Total Submissions: 2.9M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 思路 
 * 用两个指针代表一个substring (i,j)，类似用一个window的左右两边
 * 优先将右边的指针的字母加入到Hashset里，如果可以加的话
 * 当不能加的时候，说明有重复，这时移动左边指针同时删除左边指针的字母
 * 长度为 两个指针相减 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        int i=0;
        int j = 0;
        int n=s.length();
        HashSet<Character> set = new HashSet<>();
        while(j<n){
            if(set.add(s.charAt(j))){
                j++;
                maxLength=Math.max(maxLength, j-i);
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}
