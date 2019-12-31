/*
 * @lc app=leetcode id=1032 lang=java
 *
 * [1032] Stream of Characters
 *
 * https://leetcode.com/problems/stream-of-characters/description/
 *
 * algorithms
 * Hard (43.30%)
 * Likes:    136
 * Dislikes: 33
 * Total Accepted:    7.8K
 * Total Submissions: 17.8K
 * Testcase Example:  '["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query"]\n' +
  '[[["cd","f","kl"]],["a"],["b"],["c"],["d"],["e"],["f"],["g"],["h"],["i"],["j"],["k"],["l"]]'
 *
 * Implement the StreamChecker class as follows:
 * 
 * 
 * StreamChecker(words): Constructor, init the data structure with the given
 * words.
 * query(letter): returns true if and only if for some k >= 1, the last k
 * characters queried (in order from oldest to newest, including this letter
 * just queried) spell one of the words in the given list.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init
 * the dictionary.
 * streamChecker.query('a');          // return false
 * streamChecker.query('b');          // return false
 * streamChecker.query('c');          // return false
 * streamChecker.query('d');          // return true, because 'cd' is in the
 * wordlist
 * streamChecker.query('e');          // return false
 * streamChecker.query('f');          // return true, because 'f' is in the
 * wordlist
 * streamChecker.query('g');          // return false
 * streamChecker.query('h');          // return false
 * streamChecker.query('i');          // return false
 * streamChecker.query('j');          // return false
 * streamChecker.query('k');          // return false
 * streamChecker.query('l');          // return true, because 'kl' is in the
 * wordlist
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * Words will only consist of lowercase English letters.
 * Queries will only consist of lowercase English letters.
 * The number of queries is at most 40000.
 * 
 * 
 */

// @lc code=start
class StreamChecker {

    TrieNode root;
    List<Character> list;
    public StreamChecker(String[] words) {
        list = new ArrayList<>();
        root = new TrieNode();
        
        for (String word: words) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; --i) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }
    }
    
    public boolean query(char letter) {
        list.add(letter);
        TrieNode cur = root;
        for (int i = list.size() - 1; i >= 0; --i) {
            int index = list.get(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
            if (cur.isWord) {
                return true;
            }
        }
        return false;
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
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
// @lc code=end

