/*
 * @lc app=leetcode id=916 lang=java
 *
 * [916] Word Subsets
 *
 * https://leetcode.com/problems/word-subsets/description/
 *
 * algorithms
 * Medium (45.84%)
 * Likes:    207
 * Dislikes: 53
 * Total Accepted:    13.3K
 * Total Submissions: 29K
 * Testcase Example:  '["amazon","apple","facebook","google","leetcode"]\n["e","o"]'
 *
 * We are given two arrays A and B of words.  Each word is a string of
 * lowercase letters.
 * 
 * Now, say that word b is a subset of word a if every letter in b occurs in a,
 * including multiplicity.  For example, "wrr" is a subset of "warrior", but is
 * not a subset of "world".
 * 
 * Now say a word a from A is universal if for every b in B, b is a subset of
 * a. 
 * 
 * Return a list of all universal words in A.  You can return the words in any
 * order.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * Output: ["apple","google","leetcode"]
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"]
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B =
 * ["lo","eo"]
 * Output: ["google","leetcode"]
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B =
 * ["ec","oc","ceo"]
 * Output: ["facebook","leetcode"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length, B.length <= 10000
 * 1 <= A[i].length, B[i].length <= 10
 * A[i] and B[i] consist only of lowercase letters.
 * All words in A[i] are unique: there isn't i != j with A[i] == A[j].
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return res;
        }
        
        int n = B.length;
        int[][] cnt = new int[n][26];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < B[i].length(); ++j) {
                cnt[i][B[i].charAt(j) - 'a']++;
            }
        }
        
        int[] maxCnt = new int[26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < n; ++j) {
                maxCnt[i] = Math.max(maxCnt[i], cnt[j][i]);
            }
        }
        
        for (String a: A) {
            int[] cntA = new int[26];
            for (int i = 0; i < a.length(); ++i) {
                cntA[a.charAt(i) - 'a']++;
            }
            boolean isValid = true;
            for (int i = 0; i < 26; ++i) {
                if (cntA[i] < maxCnt[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) res.add(a);
        }
        return res;
    }
}
// @lc code=end

