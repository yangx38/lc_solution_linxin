/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (31.43%)
 * Likes:    1357
 * Dislikes: 453
 * Total Accepted:    266.3K
 * Total Submissions: 847.3K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1;
        int top = 0, down = m - 1;

        while (left <= right && top <= down) {
            for (int j = left; j <= right; ++j) {
                res.add(matrix[top][j]);
            }
            top++;
            if (top > down) break;

            for (int i = top; i <= down; ++i) {
                res.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;

            for (int j = right; j >= left; --j) {
                res.add(matrix[down][j]);
            }
            down--;
            if (down < top) break;

            for (int i = down; i >= top; --i) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}

