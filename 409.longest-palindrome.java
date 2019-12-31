/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (48.67%)
 * Likes:    620
 * Dislikes: 64
 * Total Accepted:    109.8K
 * Total Submissions: 225.2K
 * Testcase Example:  '"abccccdd"'
 *
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome
 * here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * 
 * Example: 
 * 
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for (char c: s.toCharArray()) {
            cnt[c]++;
        }
        
        int even = 0;
        int odd = 0;
        for (int c: cnt) {
            even += c / 2;
            odd += c % 2;
        }
        
        if (odd > 1) {
            odd = 1;
        }
        return even * 2 + odd;
    }
}
// @lc code=end

