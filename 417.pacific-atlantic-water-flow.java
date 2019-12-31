/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (38.30%)
 * Likes:    757
 * Dislikes: 140
 * Total Accepted:    51K
 * Total Submissions: 133.1K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a
 * cell to another one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 * 
 * Note:
 * 
 * 
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given the following 5x5 matrix:
 * 
 * ⁠ Pacific ~   ~   ~   ~   ~ 
 * ⁠      ~  1   2   2   3  (5) *
 * ⁠      ~  3   2   3  (4) (4) *
 * ⁠      ~  2   4  (5)  3   1  *
 * ⁠      ~ (6) (7)  1   4   5  *
 * ⁠      ~ (5)  1   1   2   4  *
 * ⁠         *   *   *   *   * Atlantic
 * 
 * Return:
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with
 * parentheses in above matrix).
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        Queue<Integer> q = new LinkedList<>();
        for (int j = 0; j < n; ++j) {
            res[0][j] |= 1;
            q.offer(j);
            res[m - 1][j] |= 2;
            q.offer((m - 1) * n + j);
        }

        for (int i = 0; i < m; ++i) {
            res[i][0] |= 1;
            q.offer(i * n);
            res[i][n - 1] |= 2;
            q.offer(i * n + n - 1);
        }

        int[] dirs = {0, 1, 0, -1, 0};
        while (!q.isEmpty()) {
            int cur = q.poll();
            int x = cur / n;
            int y = cur % n;
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i];
                int ny = y + dirs[i + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n 
                && matrix[nx][ny] >= matrix[x][y] && (res[nx][ny] | res[x][y]) > res[nx][ny]) {
                    res[nx][ny] |= res[x][y];
                    q.offer(nx * n + ny);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (res[i][j] == 3) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}

