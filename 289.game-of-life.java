import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 *
 * https://leetcode.com/problems/game-of-life/description/
 *
 * algorithms
 * Medium (43.31%)
 * Total Accepted:    102.2K
 * Total Submissions: 234.2K
 * Testcase Example:  '[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]'
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply
 * as Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal,
 * vertical, diagonal) using the following four rules (taken from the above
 * Wikipedia article):
 * 
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population.
 * Any live cell with two or three live neighbors lives on to the next
 * generation.
 * Any live cell with more than three live neighbors dies, as if by
 * over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if
 * by reproduction.
 * 
 * 
 * Write a function to compute the next state (after one update) of the board
 * given its current state. The next state is created by applying the above
 * rules simultaneously to every cell in the current state, where births and
 * deaths occur simultaneously.
 * 
 * Example:
 * 
 * 
 * Input: 
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output: 
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * 
 * 
 * Follow up:
 * 
 * 
 * Could you solve it in-place? Remember that the board needs to be updated at
 * the same time: You cannot update some cells first and then use their updated
 * values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the
 * board is infinite, which would cause problems when the active area
 * encroaches the border of the array. How would you address these problems?
 * 
 * 思路一：
 * 很简单，新建一个二维数组，将每一个数组元素的下一个状态一一检查
 * 并存入这个新的二维数组，最后将原来的数组更新
 * 注意：必须要for来更新，好像跟指针有点关系，不能用 。clone
 * 思路二：
 * bit operation
 * 不用新建一个数组，将每个元素的下一个状态存到第二个bit上 
 * 01 生到死  1 下一个状态是0不用管
 * 11 生到生  3
 * 10 死到生  2 
 * 00 死到死  0 下一个状态是0不用管
 * 然后将整个数组向右移动一位即可
 */
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = update(board, i, j, m, n);
                if ((count == 2 || count == 3) && (board[i][j] & 1) == 1)
                    board[i][j] = 3;
                if (count == 3 && (board[i][j] & 1) == 0)
                    board[i][j] = 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int update(int[][] board, int x, int y, int m, int n) {
        int count = 0;
        for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, m - 1); i++) {
            for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, n - 1); j++) {
                count += board[i][j] & 1;
            }
        }
        return count -= board[x][y] & 1;
    }

    // int m = board.length;
    // int n = board[0].length;
    // int[][] updated = new int[m][n];
    // for (int i = 0; i < m; i++) {
    // for (int j = 0; j < n; j++) {
    // updated[i][j] = update(board, i, j, m, n);
    // }
    // }
    // for(int i =0 ;i< m ;i++){
    // for (int j=0 ;j<n ;j++){
    // board[i][j]=updated[i][j];
    // }
    // }
    // }

    // private int update(int[][] board, int x, int y, int m, int n) {
    // int count = 0;
    // for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, m - 1); i++) {
    // for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, n - 1); j++) {
    // if (board[i][j] == 1) {
    // count++;
    // }
    // }
    // }
    // count -= board[x][y];
    // if (board[x][y] == 1 && count < 2) {
    // return 0;
    // } else if (board[x][y] == 1 && count >= 2 && count <= 3) {
    // return 1;
    // } else if (board[x][y] == 1 && count > 3) {
    // return 0;
    // } else if (board[x][y] == 0 && count == 3) {
    // return 1;
    // } else {
    // return 0;
    // }
    // }
}
