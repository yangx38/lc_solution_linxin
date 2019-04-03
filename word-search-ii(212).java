// so if board[i][j] match the char in triNode tree, then we continue, otherwise not
// bruth force is O(mn 4^k)
// 注意这道题 用 String word = null 标志结束 instead of using isEnd

// T = O(m * n * TrieNode)
// S = TrieNode
class Solution {
    // 1. TrieNode class
    class TrieNode {
        Map<Character, TrieNode> children;
        String word;
        
        public TrieNode() {
            children = new HashMap<>();
            word = null;
        }
    }

    // 2. Build Trie
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            insert(root, word);
        }
        return root;
    }
    private void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = cur.children.get(c);
            if(node == null) {
                node = new TrieNode();
                cur.children.put(c, node);
            }
            cur = node;
        }
        cur.word = word;
    }

    // 3. buildTrie based on words, and do DFS search
    private int m, n;
    private List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        m = board.length; n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(board, root, i, j);
            }
        }
        return res;
    }

    // 4. DFS helper
    public void helper(char[][] board, TrieNode cur, int i, int j) {
        // valid case
         if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        // invalid case1
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        // invalid case2
        char c = board[i][j];
        if (c == '#' || cur.children.get(c) == null) return;
        cur = cur.children.get(c);
       
        board[i][j] = '#';
        helper(board, cur, i-1, j);
        helper(board, cur, i+1, j);
        helper(board, cur, i, j-1);
        helper(board, cur, i, j+1);
        board[i][j] = c;
    }
}