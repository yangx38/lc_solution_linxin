/*
 * @lc app=leetcode id=1074 lang=java
 *
 * [1074] Number of Submatrices That Sum to Target
 *
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/description/
 *
 * algorithms
 * Hard (58.01%)
 * Likes:    162
 * Dislikes: 8
 * Total Accepted:    4.9K
 * Total Submissions: 8.4K
 * Testcase Example:  '[[0,1,0],[1,1,1],[0,1,0]]\n0'
 *
 * Given a matrix, and a target, return the number of non-empty submatrices
 * that sum to target.
 * 
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x
 * <= x2 and y1 <= y <= y2.
 * 
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if
 * they have some coordinate that is different: for example, if x1 != x1'.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the
 * 2x2 submatrix.
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= matrix.length <= 300
 * 1 <= matrix[0].length <= 300
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int cnt = 0;
        for (int l = 0; l < n; ++l) {
            int[] sum = new int[m];
            
            for (int r = l; r < n; ++r) {
                for (int i = 0; i < m; ++i) {
                    sum[i] += matrix[i][r];
                }    
                
                cnt += calc(sum, target);
            }
        }
        return cnt;
    }
    
    private int calc(int[] nums, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int sum = 0, cnt = 0;
        for (int num: nums) {
            sum += num;
            if (map.containsKey(sum - t)) {
                cnt += map.get(sum - t);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
// @lc code=end

