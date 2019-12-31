/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 *
 * https://leetcode.com/problems/redundant-connection/description/
 *
 * algorithms
 * Medium (53.28%)
 * Likes:    797
 * Dislikes: 201
 * Total Accepted:    60.9K
 * Total Submissions: 114.1K
 * Testcase Example:  '[[1,2],[1,3],[2,3]]'
 *
 * 
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 * 
 * The given input is a graph that started as a tree with N nodes (with
 * distinct values 1, 2, ..., N), with one additional edge added.  The added
 * edge has two different vertices chosen from 1 to N, and was not an edge that
 * already existed.
 * 
 * The resulting graph is given as a 2D-array of edges.  Each element of edges
 * is a pair [u, v] with u < v, that represents an undirected edge connecting
 * nodes u and v.
 * 
 * Return an edge that can be removed so that the resulting graph is a tree of
 * N nodes.  If there are multiple answers, return the answer that occurs last
 * in the given 2D-array.  The answer edge [u, v] should be in the same format,
 * with u < v.
 * Example 1:
 * 
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 * ⁠ 1
 * ⁠/ \
 * 2 - 3
 * 
 * 
 * Example 2:
 * 
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 * ⁠   |   |
 * ⁠   4 - 3
 * 
 * 
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N
 * is the size of the input array.
 * 
 * 
 * 
 * 
 * 
 * Update (2017-09-26):
 * We have overhauled the problem description + test cases and specified
 * clearly the graph is an undirected graph. For the directed graph follow up
 * please see Redundant Connection II). We apologize for any inconvenience
 * caused.
 * 
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        int[] res = null;
        for (int[] edge: edges) {
            int u = edge[0], v = edge[1];
            if (!uf.union(u, v)) {
                res = edge;
            }
        }
        return res;
    }
}

class UnionFind{
    int[] f;
    int[] sz;
    public UnionFind(int n) {
        f = new int[n + 1];
        sz = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = i;
            sz[i] = 1;
        }
    }
    
    public boolean union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        if (rootA != rootB) {
            if (sz[rootA] <= sz[rootB]) {
                f[rootA] = rootB;
                sz[rootB] += sz[rootA];
            }else {
                f[rootB] = rootA;
                sz[rootA] += sz[rootB];
            }
            return true;
        }
        return false;
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
}

