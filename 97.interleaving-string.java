/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 *
 * https://leetcode.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (28.89%)
 * Likes:    915
 * Dislikes: 52
 * Total Accepted:    121.6K
 * Total Submissions: 420.7K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
 * s2.
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int m = s1.length(), n = s2.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        
        for (int i = 1; i <= m; ++i) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                f[i][0] = f[i - 1][0];
            }    
        }
        
        
        for (int j = 1; j <= n; ++j) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                f[0][j] = f[0][j - 1];
            }
        }
        
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    f[i][j] |= f[i - 1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    f[i][j] |= f[i][j - 1];
                }
            }
        }
        return f[m][n];
    }
}

