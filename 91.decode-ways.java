/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.87%)
 * Likes:    1717
 * Dislikes: 1957
 * Total Accepted:    299K
 * Total Submissions: 1.3M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            char c = s.charAt(i - 1);
            if (c != '0') {
                f[i] += f[i - 1];
            }
            if (i >= 2) {
                int num = (s.charAt(i - 2) - '0') * 10 + c - '0';
                if (num >= 10 && num <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[n];
    }
}
// @lc code=end

