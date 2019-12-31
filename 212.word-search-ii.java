/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (30.05%)
 * Likes:    1412
 * Dislikes: 79
 * Total Accepted:    133.4K
 * Total Submissions: 442.1K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n' +
  '["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * board = [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 * 
 * 
 */
class Solution {
    /*
    brute force:
        words.length() * m * n * 4 * word.length();
    TrieNode:
        m * n * 4 * 
    */
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            insert(root, word);
        }  

        int m = board.length, n = board[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(i, j, board, root, res, dirs);
            }
        }
        return res;
    }

    private void dfs(int x, int y, char[][] board, TrieNode cur, List<String> res, 
    int[] dirs) {
        char c = board[x][y];
        cur = cur.children[c - 'a'];
        if (cur == null) {
            return;
        }
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }

        int m = board.length, n = board[0].length;
        char temp = board[x][y];
        board[x][y] = '#';
        for (int i = 0; i < 4; ++i) {
            int nx = x + dirs[i];
            int ny = y + dirs[i + 1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] != '#') {
                dfs(nx, ny, board, cur, res, dirs);
            }
        }
        board[x][y] = temp;
    }

    private void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.word = word;
    }
}

class TrieNode{
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}

