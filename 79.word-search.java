/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (32.37%)
 * Likes:    2223
 * Dislikes: 113
 * Total Accepted:    332.2K
 * Total Submissions: 1M
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
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 ||
        word == null || word.length() == 0) {
            return false;
        } 

        char c = word.charAt(0);
        int m = board.length, n = board[0].length;
        int[] dirs = {0, 1, 0, -1, 0};

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == c) {
                    if (canFindWord(1, word, i, j, board, dirs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean canFindWord(int index, String word, int x, int y,
    char[][] board, int[] dirs) {
        if (index == word.length()) {
            return true;
        }

        int m = board.length, n = board[0].length;
        board[x][y] = '*';
        for (int i = 0; i < 4; ++i) {
            int nx = x + dirs[i];
            int ny = y + dirs[i + 1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == word.charAt(index)) {
                if (canFindWord(index + 1, word, nx, ny, board, dirs)) {
                    return true;
                }
            }
        }
        board[x][y] = word.charAt(index - 1);
        return false;
    }
}

