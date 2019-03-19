import java.util.HashMap;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (34.51%)
 * Total Accepted:    131.9K
 * Total Submissions: 381.4K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Example 1:
 * 
 * 
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * 
 * Example 4:
 * 
 * 
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 * 
 * String 比较要用 equals!!!
 * 获取strlist 用split(" ")
 * 思路1：o(n)
 * 第一想法用HashMap来判断是否有重复的字母 key是char value是index
 * 存一个pattern的，存一个strlist的
 * 如果第一次遇见pattern的新字母，加进去，同时判断strlist是否也为新string，是的话加进去，不是返回false
 * 如果已经有这个字母，那么找到第一次的字母的位置，判断对应位置的strlist是否相等，否则false
 * 最后检查完毕的话返回true
 * 思路2：o(n^2)
 * 只存一个hashmap <Character, String>
 * 判断的依据还是和之前一样
 * 这样的话要用到containsvalue，时间复杂度变大了
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strlist = str.split(" ");
        if (pattern.length() != strlist.length) {
            return false;
        }
        HashMap<Character, Integer> patternMap = new HashMap<>();
        HashMap<String, Integer> strMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if (!patternMap.containsKey(c)) {
                patternMap.put(c, i);
                if (strMap.containsKey(strlist[i])) {
                    return false;
                } else {
                    strMap.put(strlist[i], i);
                }
            } else {
                if (!strlist[i].equals(strlist[patternMap.get(c)])) {
                    return false;
                }
            }
        }
        return true;
    }
}
