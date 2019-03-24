import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (30.36%)
 * Total Accepted:    259.1K
 * Total Submissions: 846.8K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 * 思路；
 * dfs
 * 每个点都进行一次dfs
 * dfs
 * 1.首先确定边界，如果边界没问题则比较对应字母是否和word的相等
 * 2.如果都没问题，判断是否已经到终点，index==word的长度-1
 * 3.否则继续进行深搜，注意将已经用过的点用 ‘*‘代替，避免重复使用
 * 返回4个方向的或集
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index >= word.length() || i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || word.charAt(index) != board[i][j])
            return false;
        else if (index == word.length() - 1)
            return true;
        else {
            char c = board[i][j];
            board[i][j] = '*';
            boolean result = dfs(board, word, index + 1, i - 1, j) || dfs(board, word, index + 1, i + 1, j)
                    || dfs(board, word, index + 1, i, j - 1) || dfs(board, word, index + 1, i, j + 1);
            board[i][j] = c;
            return result;
        }
    }

}
