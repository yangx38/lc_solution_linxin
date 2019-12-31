/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (48.31%)
 * Likes:    553
 * Dislikes: 86
 * Total Accepted:    149K
 * Total Submissions: 308.3K
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
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0, down = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        int[][] matrix = new int[n][n];
        while (num <= n * n) {
            for (int j = left; j <= right; ++j) {
                matrix[top][j] = num++;
            }
            top++;

            for (int i = top; i <= down; ++i) {
                matrix[i][right] = num++;
            }

            right--;
            for (int j = right; j >= left; --j) {
                matrix[down][j] = num++;
            }
            down--;

            for (int i = down; i >= top; --i) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }
}

