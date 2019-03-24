/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (45.29%)
 * Total Accepted:    129.4K
 * Total Submissions: 283.9K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 思路：
 * 同54：
 * 按照题目要求顺序 遍历矩阵 while
 * 1. 左到右 top--
 * 2.上到下  right--；
 * 3. 右到左 bottom ++ 
 * 4， 下到上 left++    
 * 
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int count = 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                result[top][j] = count;
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = count;
                count++;
            }
            right--;
            for (int j = right; j >= left; j--) {
                result[bottom][j] = count;
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result[i][left] = count;
                count++;
            }
            left++;

        }
        return result;
    }
}
