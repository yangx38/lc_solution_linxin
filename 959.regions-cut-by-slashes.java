/*
 * @lc app=leetcode id=959 lang=java
 *
 * [959] Regions Cut By Slashes
 *
 * https://leetcode.com/problems/regions-cut-by-slashes/description/
 *
 * algorithms
 * Medium (62.89%)
 * Likes:    380
 * Dislikes: 85
 * Total Accepted:    9.4K
 * Total Submissions: 14.9K
 * Testcase Example:  '[" /","/ "]'
 *
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a
 * /, \, or blank space.  These characters divide the square into contiguous
 * regions.
 * 
 * (Note that backslash characters are escaped, so a \ is represented as
 * "\\".)
 * 
 * Return the number of regions.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * " /",
 * "/ "
 * ]
 * Output: 2
 * Explanation: The 2x2 grid is as follows:
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * " /",
 * "  "
 * ]
 * Output: 1
 * Explanation: The 2x2 grid is as follows:
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * [
 * "\\/",
 * "/\\"
 * ]
 * Output: 4
 * Explanation: (Recall that because \ characters are escaped, "\\/" refers to
 * \/, and "/\\" refers to /\.)
 * The 2x2 grid is as follows:
 * 
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * [
 * "/\\",
 * "\\/"
 * ]
 * Output: 5
 * Explanation: (Recall that because \ characters are escaped, "/\\" refers to
 * /\, and "\\/" refers to \/.)
 * The 2x2 grid is as follows:
 * 
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * [
 * "//",
 * "/ "
 * ]
 * Output: 3
 * Explanation: The 2x2 grid is as follows:
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] is either '/', '\', or ' '.
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] matrix = new boolean[3 * n][3 * n];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                char c = grid[i].charAt(j);
                if (c != ' ') {
                    if (c == '/') {
                        matrix[i * 3][j * 3 + 2] = true;
                        matrix[i * 3 + 1][j * 3 + 1] = true;
                        matrix[i * 3 + 2][j * 3] = true;
                    }else {
                        matrix[i * 3][j * 3] = true;
                        matrix[i * 3 + 1][j * 3 + 1] = true;
                        matrix[i * 3 + 2][j * 3 + 2] = true;
                    }
                }
            }
        }
        
        n *= 3;
        int regions = 0;
        int[] dirs = {0, 1, 0, -1, 0};
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!matrix[i][j]) {
                    regions++;
                    bfs(i, j, matrix, dirs);
                }
            }
        }
        return regions;
    }
    
    private void bfs(int x, int y, boolean[][] matrix, int[] dirs) {
        Queue<Integer> q = new LinkedList<>();
        int n = matrix.length;
        q.offer(x * n + y);
        matrix[x][y] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            x = cur / n;
            y = cur % n;
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i];
                int ny = y + dirs[i + 1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !matrix[nx][ny]) {
                    matrix[nx][ny] = true;
                    q.offer(nx * n + ny);
                }
            }
        }   
    }
}

