/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 *
 * https://leetcode.com/problems/concatenated-words/description/
 *
 * algorithms
 * Hard (36.74%)
 * Likes:    332
 * Dislikes: 73
 * Total Accepted:    28.3K
 * Total Submissions: 76.7K
 * Testcase Example:  '["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]'
 *
 * Given a list of words (without duplicates), please write a program that
 * returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at
 * least two shorter words in the given array.
 * 
 * Example:
 * 
 * Input:
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; "ratcatdogcat"
 * can be concatenated by "rat", "cat", "dog" and "cat".
 * 
 * 
 * 
 * Note:
 * 
 * The number of elements of the given array will not exceed 10,000 
 * The length sum of elements in the given array will not exceed 600,000. 
 * All the input string will only include lower case letters.
 * The returned elements order does not matter. 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<>();
        for (String word: words) {
            dict.add(word);
        }

        List<String> res = new ArrayList<>();
        for (String word: words) {
            if (word.isEmpty()) {
                continue;
            }
            if (isConcatenatedWord(word, dict)) {
                res.add(word);
            }
        }

        return res;
    }

    private boolean isConcatenatedWord(String word, Set<String> dict) {
        int n = word.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (j == 0 && i == n) continue;
                if (dict.contains(word.substring(j, i)) && f[j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
// @lc code=end

