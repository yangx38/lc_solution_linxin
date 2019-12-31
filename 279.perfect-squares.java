/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (43.07%)
 * Likes:    1752
 * Dislikes: 151
 * Total Accepted:    213.1K
 * Total Submissions: 493.3K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int x = (int)Math.sqrt(n);
        if (x * x == n) {
            return 1;
        }
        
        for (int i = 1; i * i < n; ++i) {
            int j = (int)Math.sqrt(n - i * i);
            if (i * i + j * j == n) {
                return 2;
            }
        }
        
        while (n % 4 == 0) {
            n /= 4;
        }
        n -= 7;
        
        if (n % 8 == 0) return 4;
        
        return 3;
    }
}
// @lc code=end

