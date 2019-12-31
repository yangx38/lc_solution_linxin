/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 *
 * https://leetcode.com/problems/longest-string-chain/description/
 *
 * algorithms
 * Medium (50.08%)
 * Likes:    226
 * Dislikes: 15
 * Total Accepted:    15.4K
 * Total Submissions: 30.4K
 * Testcase Example:  '["a","b","ba","bca","bda","bdca"]'
 *
 * Given a list of words, each word consists of English lowercase letters.
 * 
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly
 * one letter anywhere in word1 to make it equal to word2.  For example, "abc"
 * is a predecessor of "abac".
 * 
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >=
 * 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of
 * word_3, and so on.
 * 
 * Return the longest possible length of a word chain with words chosen from
 * the given list of words.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of English lowercase letters.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        //unionFind;
        
        Map<String, Integer> map = new HashMap<>();
        int id = 0, n = words.length;
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < n; ++i) {
            String s = words[i];
            if (!map.containsKey(s)) {
                map.put(s, id++);
            }
                
            for (int j = i + 1; j < n; ++j) { 
                String t = words[j];
                if (!map.containsKey(t)) {
                    map.put(t, id++);
                }
                
                if (Math.abs(s.length() - t.length()) == 1) {
                        
                    //lenS = l, lenT = l + 1;
                    if (isPredecessor(s, t)) {
                        uf.union(map.get(s), map.get(t));
                    }
                }
            }
        }
        
        int ans = 0;
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int root = uf.find(map.get(words[i]));
            components.putIfAbsent(root, new ArrayList<>());
            components.get(root).add(words[i].length());
        }
        
        for (List<Integer> component: components.values()) {
            Collections.sort(component);
            int cnt = 0;
            for (int i = 0; i < component.size(); ++i) {
                if (i == 0 || component.get(i) != component.get(i - 1)) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
    
    private boolean isPredecessor(String s, String t) {
        //lenT = lenS + 1;
        if (s.length() > t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        int l = s.length();
        
        for (int i = 0; i < l; ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return true;
    }
}

class UnionFind{
    int[] f; 
    int[] sz;
    UnionFind(int n) {
        f = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = i;
            sz[i] = 1;
        }
    }
    
    public void union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        if (rootA != rootB) {
            if (sz[rootA] <= sz[rootB]) {
                sz[rootB] += sz[rootA];
                f[rootA] = rootB;
            }else {
                sz[rootA] += sz[rootB];
                f[rootB] = rootA;
            }
        }
    }
    
    public int find(int x) {
        int r = x;
        while (f[r] != r) {
            r = f[r];
        }
        
        while (x != r) {
            int t = f[x];
            f[x] = r;
            x = t;
        }
        return r;
    }
    
    public int getSize(int root) {
        return this.sz[root];
    }
}
// @lc code=end

