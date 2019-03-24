/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (40.66%)
 * Total Accepted:    363.6K
 * Total Submissions: 891K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 * 
 * 思路：
 * 设置carry为1加到最后一个数字上
 * 然后更新最后一个数字和carry
 * carry为0后的话终止循环
 * 
 * 最后如果carry还是1
 * 新建一个数组返回 多一位的 1000...
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int len =digits.length;
        for(int i = len -1; i>=0 && carry ==1 ;i--){
            int sum = digits[i]+carry;
            carry = sum /10 ;
            digits[i]=sum%10;
        }
        if(carry==1){
            int [] result =new int [len+1];
            result[0]=1;
            return result;
        }
        return digits;
    }
}

