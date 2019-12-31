/*
 * @lc app=leetcode id=1145 lang=java
 *
 * [1145] Binary Tree Coloring Game
 *
 * https://leetcode.com/problems/binary-tree-coloring-game/description/
 *
 * algorithms
 * Medium (47.63%)
 * Likes:    131
 * Dislikes: 31
 * Total Accepted:    6.1K
 * Total Submissions: 12.8K
 * Testcase Example:  '[1,2,3,4,5,6,7,8,9,10,11]\n11\n3'
 *
 * Two players play a turn based game on a binary tree.  We are given the root
 * of this binary tree, and the number of nodes n in the tree.  n is odd, and
 * each node has a distinct value from 1 to n.
 * 
 * Initially, the first player names a value x with 1 <= x <= n, and the second
 * player names a value y with 1 <= y <= n and y != x.  The first player colors
 * the node with value x red, and the second player colors the node with value
 * y blue.
 * 
 * Then, the players take turns starting with the first player.  In each turn,
 * that player chooses a node of their color (red if player 1, blue if player
 * 2) and colors an uncolored neighbor of the chosen node (either the left
 * child, right child, or parent of the chosen node.)
 * 
 * If (and only if) a player cannot choose such a node in this way, they must
 * pass their turn.  If both players pass their turn, the game ends, and the
 * winner is the player that colored more nodes.
 * 
 * You are the second player.  If it is possible to choose such a y to ensure
 * you win the game, return true.  If it is not possible, return false.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
 * Output: true
 * Explanation: The second player can choose the node with value 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * root is the root of a binary tree with n nodes and distinct node values from
 * 1 to n.
 * n is odd.
 * 1 <= x <= n <= 100
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode[] xNode = {new TreeNode(x)};
        findParent(root, null, map, xNode);

        boolean[] visited = new boolean[n + 1];
        visited[x] = true;
        if (map.get(xNode[0]) != null) {
            int len = dfs(map.get(xNode[0]), visited, map);
            if (len > n - len) return true;
        }
        if (xNode[0].left != null) {
            int len = dfs(xNode[0].left, visited, map);
            if (len > n - len) return true;
        }
        if (xNode[0].right != null) {
            int len = dfs(xNode[0].right, visited, map);
            if (len > n - len) return true;
        }
        return false;
    }

    private void findParent(TreeNode cur, TreeNode parent, Map<TreeNode, TreeNode> map, TreeNode[] xNode) {
        if (cur == null) {
            return;
        }
        map.put(cur, parent);
        if (cur.val == xNode[0].val) {
            xNode[0] = cur;
        }
        findParent(cur.left, cur, map, xNode);
        findParent(cur.right, cur, map, xNode);
    }

    private int dfs(TreeNode cur, boolean[] visited, Map<TreeNode, TreeNode> map) {
        if (cur == null || visited[cur.val]) {
            return 0;
        }
        int cnt = 1;
        visited[cur.val] = true;
        cnt += dfs(cur.left, visited, map);
        cnt += dfs(cur.right, visited, map);
        cnt += dfs(map.get(cur), visited, map);
        return cnt;
    }
}

