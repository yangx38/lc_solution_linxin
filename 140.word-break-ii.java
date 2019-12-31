/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (28.23%)
 * Likes:    1194
 * Dislikes: 273
 * Total Accepted:    176.1K
 * Total Submissions: 622K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }
        
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int j = 1; j <= n; ++j) {
            for (int k = 0; k < j; ++k) {
                if (dict.contains(s.substring(k, j)) && f[k]) {
                    f[j] = true;
                    break;
                }
            }
        }
        
        List<String> paths = new ArrayList<>();
        boolean[] breakPoints = new boolean[n + 1];
        
        printAnswer(n, s, dict, f, breakPoints, paths);
        return paths;
    }
    
    private void printAnswer(int j, String s, Set<String> dict, boolean[] f, boolean[] breakPoints, List<String> paths) {
        if (j == 0) {
            StringBuilder sb = new StringBuilder();
            int prev = 0;
            for (int i = 1; i < breakPoints.length; ++i) {
                if (breakPoints[i]) {
                    sb.append(s.substring(prev, i));
                    prev = i;
                    sb.append(" ");
                }
            }
            sb.append(s.substring(prev));
            paths.add(sb.toString());
            return;
        }
        
        for (int k = 0; k < j; ++k) {
            if (f[k] && dict.contains(s.substring(k, j))) {
                breakPoints[k] = true;
                printAnswer(k, s, dict, f, breakPoints, paths);
                breakPoints[k] = false;
            }
        }
    }
}

