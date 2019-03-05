/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (38.93%)
 * Total Accepted:    190.9K
 * Total Submissions: 490.1K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to
 * 0. Do it in-place.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output: 
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output: 
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 
 * 
 * Follow up:
 * 
 * 
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 思路；将第一排和第一列作为参考坐标，首先记录第一行和第一列的信息
 * 如果第一列和第一行有0，那么设置 Boolean为正
 * 然后从第二行第二个开始扫描矩阵，如果遇到0，将其对应的第一行和第一列的数字设置成0
 * 然后根据第一行和第一列的信息对整个矩阵进行变化
 * 最后根据Boolean值设置第一行和第一列的数字
 * 
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null)
        return;
        boolean firstrow= false;
        boolean firstcol=false;
        for(int i=0 ; i<matrix.length;i++){
            if(matrix[i][0]==0){
                firstcol=true;
                break;
            }
        }
        for(int j=0 ;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                firstrow=true;
                break;
            }
        }
        for(int i =1 ; i< matrix.length;i++){
            for (int j= 1; j< matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1 ; i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for (int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<matrix.length;i++){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstcol){
            for(int i=0 ; i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        if(firstrow){
            for(int j=0 ; j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
    }
}

