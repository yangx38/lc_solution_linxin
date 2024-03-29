/*
 * @lc app=leetcode id=784 lang=java
 *
 * [784] Letter Case Permutation
 *
 * https://leetcode.com/problems/letter-case-permutation/description/
 *
 * algorithms
 * Easy (58.94%)
 * Likes:    766
 * Dislikes: 91
 * Total Accepted:    57.9K
 * Total Submissions: 98K
 * Testcase Example:  '"a1b2"'
 *
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.  Return a list of all possible
 * strings we could create.
 * 
 * 
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345"
 * Output: ["12345"]
 * 
 * 
 * Note:
 * 
 * 
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 * 
 * 
 */
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(0, S.toCharArray(), res);
        return res;
    }
    private void dfs(int index, char[] sc, List<String> res) {
        if (index == sc.length) {
            res.add(new String(sc));
            return;
        }

        dfs(index + 1, sc, res);
        if (sc[index] >= 65) {
            sc[index] ^= 32;
            dfs(index + 1, sc, res);
            sc[index] ^= 32;
        }
    }
}

