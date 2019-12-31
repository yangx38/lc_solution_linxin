/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (39.39%)
 * Likes:    2480
 * Dislikes: 39
 * Total Accepted:    196.6K
 * Total Submissions: 498.4K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 */
class Solution {
    public int minDistance(String s, String t) {
        if (s == null || t == null) {
            return -1;
        }

        int m = s.length(), n = t.length();
        int[] prev = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            prev[i] = i;
        }

        
        for (int i = 1; i <= m; ++i) {
            int p = prev[0];
            int temp = i;

            for (int j = 1; j <= n; ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    next[j] = prev[j - 1];
                }else {
                    next[j] = Math.min(prev[j - 1], Math.min(prev[j], next[j - 1])) + 1;
                }
            }
            prev = next;
        }
        return prev[n];
    }
}

