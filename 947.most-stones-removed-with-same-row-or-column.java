/*
 * @lc app=leetcode id=947 lang=java
 *
 * [947] Most Stones Removed with Same Row or Column
 *
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
 *
 * algorithms
 * Medium (54.80%)
 * Likes:    576
 * Dislikes: 173
 * Total Accepted:    30.9K
 * Total Submissions: 56.5K
 * Testcase Example:  '[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]'
 *
 * On a 2D plane, we place stones at some integer coordinate points.  Each
 * coordinate point may have at most one stone.
 * 
 * Now, a move consists of removing a stone that shares a column or row with
 * another stone on the grid.
 * 
 * What is the largest possible number of moves we can make?
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: stones = [[0,0]]
 * Output: 0
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int removeStones(int[][] stones) {
       // 0 -9999 行， 10000 - 20000 是列。
        UnionFind uf = new UnionFind(20010);
        for (int[] stone: stones) {
            uf.union(stone[0], stone[1] + 10000);
        }

        Set<Integer> components = new HashSet<>();
        for (int[] stone: stones) {
            components.add(uf.find(stone[0]));
        }
        return stones.length - components.size();
    }
}

class UnionFind{
    int[] f;
    UnionFind(int n ) {
        f = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = i;
        }
    }

    public void union(int a, int b) {
        f[find(a)] = find(b);
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
// @lc code=end

