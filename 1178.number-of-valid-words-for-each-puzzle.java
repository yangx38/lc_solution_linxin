/*
 * @lc app=leetcode id=1178 lang=java
 *
 * [1178] Number of Valid Words for Each Puzzle
 *
 * https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/description/
 *
 * algorithms
 * Hard (30.00%)
 * Likes:    56
 * Dislikes: 6
 * Total Accepted:    1.8K
 * Total Submissions: 6.1K
 * Testcase Example:  '["aaaa","asas","able","ability","actt","actor","access"]\n' +
  '["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]'
 *
 * With respect to a given puzzle string, a word is valid if both the following
 * conditions are satisfied:
 * 
 * word contains the first letter of puzzle.
 * For each letter in word, that letter is in puzzle.
 * For example, if the puzzle is "abcdefg", then valid words are "faced",
 * "cabbage", and "baggage"; while invalid words are "beefed" (doesn't include
 * "a") and "based" (includes "s" which isn't in the puzzle).
 * 
 * Return an array answer, where answer[i] is the number of words in the given
 * word list words that are valid with respect to the puzzle puzzles[i].
 * 
 * Example :
 * 
 * 
 * Input: 
 * words = ["aaaa","asas","able","ability","actt","actor","access"], 
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * Output: [1,1,3,2,4,0]
 * Explanation:
 * 1 valid word for "aboveyz" : "aaaa" 
 * 1 valid word for "abrodyz" : "aaaa"
 * 3 valid words for "abslute" : "aaaa", "asas", "able"
 * 2 valid words for "absoryz" : "aaaa", "asas"
 * 4 valid words for "actresz" : "aaaa", "asas", "actt", "access"
 * There're no valid words for "gaswxyz" cause none of the words in the list
 * contains letter 'g'.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] are English lowercase letters.
 * Each puzzles[i] doesn't contain repeated characters.
 * 
 * 
 */
class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            char[] sc = word.toCharArray();
            Arrays.sort(sc);
            insert(root, sc);
        }

        List<Integer> res = new ArrayList<>();
        for (String puzzle: puzzles) {
            int[] t = {0};
            boolean[] exist = new boolean[26];
            for (int i = 0; i < puzzle.length(); ++i) {
                exist[puzzle.charAt(i) - 'a'] = true;
            }
            dfs(root, t, puzzle.charAt(0) - 'a', false, exist);
            res.add(t[0]);
        }
        return res;
    }

    private void dfs(TrieNode cur, int[] t, int firstChar, boolean k, boolean[] exist) {
        if (cur == null) return;
        if (k) {
            t[0] += cur.cnt;
        }

        for (int i = 0; i < 26; ++i) {
            if (cur.children[i] != null && exist[i]) {
                dfs(cur.children[i], t, firstChar, k || (firstChar == i), exist);
            }
        }
    }

    private void insert(TrieNode root, char[] sc) {
        TrieNode cur = root;
        for (int i = 0; i < sc.length; ++i) {
            if (i == 0 || sc[i] != sc[i - 1]) {
                if (cur.children[sc[i] - 'a'] == null) {
                    cur.children[sc[i] - 'a'] = new TrieNode();
                }
                cur = cur.children[sc[i] - 'a'];
            }
        }
        cur.cnt++;
    }
}

class TrieNode{
    TrieNode[] children;
    int cnt;
    TrieNode() {
        children = new TrieNode[26];
        cnt = 0;
    }
}

