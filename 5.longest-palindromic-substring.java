/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.82%)
 * Likes:    4208
 * Dislikes: 393
 * Total Accepted:    639.7K
 * Total Submissions: 2.3M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int start = -1, maxLen = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            for (int l = i, r = i; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    start = l;
                }
            }
            for (int l = i, r = i + 1; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    start = l;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}

