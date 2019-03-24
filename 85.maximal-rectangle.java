/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 *
 * https://leetcode.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (32.37%)
 * Total Accepted:    114K
 * Total Submissions: 349.7K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * Output: 6
 * 
 * 思路：
 * 利用84题的答案
 * 比如这个matrix有n行，就把这个问题转换成n个Histogram的问题。
 * 每个问题就是一个以这一行为底的Histogram问题，上面连续的1的个数就是Height。
 * 取这n个问题的答案的最大值


 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int[] currentLevel = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    currentLevel[j]++;
                else
                    currentLevel[j] = 0;
            }
            max = Math.max(largestRectangleArea(currentLevel), max);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];
                int curWidth = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, curHeight * curWidth);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
