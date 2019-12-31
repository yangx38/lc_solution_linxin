/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (50.66%)
 * Likes:    1435
 * Dislikes: 89
 * Total Accepted:    128K
 * Total Submissions: 252.5K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * 
 * Example:
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * 
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[m - 1][n - 1];

        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = cntSmallerThanOrEqualTo(matrix, mid);
            if (cnt >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int cntSmallerThanOrEqualTo(int[][] matrix, int target) {
        int cnt = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] > target) continue;
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1>> 1;
                if (matrix[i][mid] <= target) l = mid;
                else r = mid - 1;
            }
            cnt += l + 1;
        }
        return cnt;
    }
}

