import java.util.Arrays;

/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (54.17%)
 * Total Accepted:    234.3K
 * Total Submissions: 432.4K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array nums of n integers where n > 1,  return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does
 * not count as extra space for the purpose of space complexity analysis.)
 * 
 * 思路：
 * 从前外后扫一遍，再从后往前扫一遍，
 * 每次先更新result，用temp记录到当前位置之前的乘积之和
 * 然后更新temp
 * 这样第一遍后每个位置有了它之前的位置的乘积之后
 * 相同的，从后往前扫一遍之后，每个位置有了它之后的位置的乘积之和
 * 最后返回这个数组即可
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        //Arrays.fill(result, 1);
        for (int i = 0, product = 1; i < nums.length; i++) {
            result[i] = product;
            product *= nums[i];
        }
        for (int i = nums.length - 1, product = 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }
}
