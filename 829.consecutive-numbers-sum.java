/*
 * @lc app=leetcode id=829 lang=java
 *
 * [829] Consecutive Numbers Sum
 *
 * https://leetcode.com/problems/consecutive-numbers-sum/description/
 *
 * algorithms
 * Hard (34.29%)
 * Likes:    196
 * Dislikes: 294
 * Total Accepted:    14.1K
 * Total Submissions: 41K
 * Testcase Example:  '5'
 *
 * Given a positive integer N, how many ways can we write it as a sum of
 * consecutive positive integers?
 * 
 * Example 1:
 * 
 * 
 * Input: 5
 * Output: 2
 * Explanation: 5 = 5 = 2 + 3
 * 
 * Example 2:
 * 
 * 
 * Input: 9
 * Output: 3
 * Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * 
 * Example 3:
 * 
 * 
 * Input: 15
 * Output: 4
 * Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * 
 * Note: 1 <= N <= 10 ^ 9.
 * 
 */

// @lc code=start
class Solution {
    public int consecutiveNumbersSum(int N) {
        // (a + a + k - 1) * k / 2 = N;
        // (2a + k - 1) * k = 2N;
        
        N += N;
        int ans = 0;
        for (int i = 1; i * i <= N; ++i) {
            if (N % i == 0) {
                int k = i, a = N / k + 1 - k;
                if (a % 2 == 0 && a > 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

