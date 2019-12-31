/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (38.41%)
 * Likes:    1850
 * Dislikes: 141
 * Total Accepted:    148.7K
 * Total Submissions: 385.2K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }

        int[] cntP = new int[26];
        int typeOfChars = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (++cntP[p.charAt(i) - 'a'] == 1) {
                typeOfChars++;
            }
        }

        int[] cntS = new int[26];
        int j = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (++cntS[s.charAt(i) - 'a'] == cntP[s.charAt(i) - 'a']) {
                typeOfChars--;
            }

            while (typeOfChars == 0) {
                if (i - j + 1 == p.length()) {
                    res.add(j);
                }
                if (cntS[s.charAt(j) - 'a']-- == cntP[s.charAt(j++) - 'a']) {
                    typeOfChars++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

