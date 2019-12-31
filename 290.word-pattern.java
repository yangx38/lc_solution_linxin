/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (35.57%)
 * Likes:    755
 * Dislikes: 97
 * Total Accepted:    155.6K
 * Total Submissions: 436.8K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Example 1:
 * 
 * 
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * 
 * Example 4:
 * 
 * 
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters that may be separated by a single space.
 * 
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        //char ->string;
        //string ->char;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        int n = pattern.length();
        for (int i = 0; i < n; ++i) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) {
                    return false;
                }
            }else {
                if (set.contains(word)) return false;
                map.put(c, word);
                set.add(word);
            }
        }
        return true;
    }
}

