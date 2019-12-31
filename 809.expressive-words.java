/*
 * @lc app=leetcode id=809 lang=java
 *
 * [809] Expressive Words
 *
 * https://leetcode.com/problems/expressive-words/description/
 *
 * algorithms
 * Medium (44.78%)
 * Likes:    133
 * Dislikes: 419
 * Total Accepted:    18.4K
 * Total Submissions: 41.1K
 * Testcase Example:  '"heeellooo"\n["hello", "hi", "helo"]'
 *
 * Sometimes people repeat letters to represent extra feeling, such as "hello"
 * -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have
 * groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".
 * 
 * For some given string S, a query word is stretchy if it can be made to be
 * equal to S by any number of applications of the following extension
 * operation: choose a group consisting of characters c, and add some number of
 * characters c to the group so that the size of the group is 3 or more.
 * 
 * For example, starting with "hello", we could do an extension on the group
 * "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has
 * size less than 3.  Also, we could do another extension like "ll" -> "lllll"
 * to get "helllllooo".  If S = "helllllooo", then the query word "hello" would
 * be stretchy because of these two extension operations: query = "hello" ->
 * "hellooo" -> "helllllooo" = S.
 * 
 * Given a list of query words, return the number of words that are
 * stretchy. 
 * 
 * 
 * 
 * 
 * Example:
 * Input: 
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation: 
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size
 * 3 or more.
 * 
 * 
 * 
 * 
 * Notes: 
 * 
 * 
 * 0 <= len(S) <= 100.
 * 0 <= len(words) <= 100.
 * 0 <= len(words[i]) <= 100.
 * S and all words in words consist only of lowercase letters
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int expressiveWords(String S, String[] words) {
        int ans = 0;
        for (String word: words) {
            int i = 0, m = S.length();
            int j = 0, n = word.length();
            while (i < m && j < n) {
                if (S.charAt(i) != word.charAt(j)) {
                    break;
                }

                char c = S.charAt(i);
                int len1 = 1;
                while (i + 1 < m && S.charAt(i + 1) == c) {
                    i++;
                    len1++;
                }

                int len2 = 1;
                while (j + 1 < n && word.charAt(j + 1) == c) {
                    j++;
                    len2++;
                }

                if (len2 > len1) break;
                if (len2 < len1) {
                    if (len1 < 3) break;
                }
                i++;
                j++;
            }
            if (i == m && j == n) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

