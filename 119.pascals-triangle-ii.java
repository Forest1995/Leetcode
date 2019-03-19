import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (42.00%)
 * Total Accepted:    186K
 * Total Submissions: 441.9K
 * Testcase Example:  '3'
 *
 * Given a non-negative index k where k ≤ 33, return the k^th index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: [1,3,3,1]
 * 
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * 思路 ：由于只让用一行的空间复杂度
 * 所以想到每次用自己更新自己
 * 问题是如何保证自己更新自己的时候不受到更新后那部分数组的影响
 * 解决办法从后面往前开始更新，因为后面的数字更新后 在计算前面的值不受影响，
 * 最后再每一行最后加上1，最前面的可以不用动，它可以一直保持1就好
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < rowIndex; i++) {
            int n = result.size();
            for (int j = n-1; j >0; j--) {
                result.set(j,  result.get(j-1)+result.get(j));
            }
            result.add(1);
        }
        return result;
    }
}
