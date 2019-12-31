/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (57.94%)
 * Likes:    1670
 * Dislikes: 86
 * Total Accepted:    122.7K
 * Total Submissions: 211.3K
 * Testcase Example:  '"abc"'
 *
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 * 
 * Example 1:
 * 
 * 
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The input string length won't exceed 1000.
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        int cnt = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            for (int l = i, r = i; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
                cnt++;
            }    
            for (int l = i, r = i + 1; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
                cnt++;
            }
        }
        return cnt;
    }
}
// @lc code=end

