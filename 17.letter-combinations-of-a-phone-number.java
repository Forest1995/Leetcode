import java.util.ArrayList;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (40.35%)
 * Total Accepted:    347.3K
 * Total Submissions: 860.5K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 思路
 * 因为要找到所有的可能组合
 * 所以第一时间想到backtracking
 * 首先需要pre建立一个mapping表，对应的数字和字母
 * 然后用StringBuilder进行组合
 * 注：StringBuilder需要删除最后一个字符
 
 */
class Solution {
    String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;
        backtracking(digits, result, new StringBuilder(), 0);
        return result;
    }

    private void backtracking(String digits, List<String> result, StringBuilder sb, int index) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String value = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < value.length(); i++) {
            backtracking(digits, result, sb.append(value.charAt(i)), index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
