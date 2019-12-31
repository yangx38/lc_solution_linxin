/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (42.24%)
 * Likes:    1395
 * Dislikes: 53
 * Total Accepted:    122K
 * Total Submissions: 288.2K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * 
 * 
 * Example 1:
 * 
 * Given tree s:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * Given tree t:
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 * 
 * 
 * Example 2:
 * 
 * Given tree s:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * Given tree t:
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * Return false.
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
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> cnt = new HashMap<>();
    int i = 1;
    public boolean isSubtree(TreeNode s, TreeNode t) {

        map.put("#", 0);
        String x = dfs(t);
        dfs(s);
        return cnt.get(x) > 1;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "" + map.get("#");
        }

        String left = dfs(root.left);
        String right = dfs(root.right);
        String cur = root.val + "," + left + "," + right;
        if (!map.containsKey(cur)) {
            map.put(cur, i++);
        }
        String x = "" + map.get(cur);
        cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        return x;
    }
}

