/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (38.18%)
 * Likes:    881
 * Dislikes: 252
 * Total Accepted:    228.1K
 * Total Submissions: 597.3K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        int[] mapS = new int[128];
        int[] mapT = new int[128];

        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (mapS[c1] == 0 && mapT[c2] == 0) {
                mapS[c1] = c2;
                mapT[c2] = c1;
            }else if (mapS[c1] != c2 || mapT[c2] != c1) {
                return false;
            }
        }
        return true;
    }
}

