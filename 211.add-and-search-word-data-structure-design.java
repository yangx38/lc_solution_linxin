/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (31.83%)
 * Likes:    1030
 * Dislikes: 60
 * Total Accepted:    131.1K
 * Total Submissions: 409K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n' +
  '[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one
 * letter.
 * 
 * Example:
 * 
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 */

// @lc code=start
class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return findWord(0, word, root);
    }

    private boolean findWord(int index, String word, TrieNode cur) {
        if (cur == null) {
            return false;
        }
        if (index == word.length()) {
            return cur.isWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; ++i) {
                if (findWord(index + 1, word, cur.children[i])) {
                    return true;
                }
            }
            return false;
        }else {
            return findWord(index + 1, word, cur.children[c - 'a']);
        }
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    TrieNode() {
        children = new TrieNode[26];
        this.isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

