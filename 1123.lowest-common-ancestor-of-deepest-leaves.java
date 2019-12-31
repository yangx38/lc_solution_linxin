/*
 * @lc app=leetcode id=1123 lang=java
 *
 * [1123] Lowest Common Ancestor of Deepest Leaves
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/
 *
 * algorithms
 * Medium (64.30%)
 * Likes:    95
 * Dislikes: 134
 * Total Accepted:    8.1K
 * Total Submissions: 12.6K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a rooted binary tree, return the lowest common ancestor of its deepest
 * leaves.
 * 
 * Recall that:
 * 
 * 
 * The node of a binary tree is a leaf if and only if it has no children
 * The depth of the root of the tree is 0, and if the depth of a node is d, the
 * depth of each of its children is d+1.
 * The lowest common ancestor of a set S of nodes is the node A with the
 * largest depth such that every node in S is in the subtree with root A.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3]
 * Output: [1,2,3]
 * Explanation: 
 * The deepest leaves are the nodes with values 2 and 3.
 * The lowest common ancestor of these leaves is the node with value 1.
 * The answer returned is a TreeNode object (not an array) with serialization
 * "[1,2,3]".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4]
 * Output: [4]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1,2,3,4,5]
 * Output: [2,4,5]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The given tree will have between 1 and 1000 nodes.
 * Each node of the tree will have a distinct value between 1 and 1000.
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
    class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair ans = dfs(root, 0);
        return ans.node;
    }

    private Pair dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return new Pair(root, depth);
        }

        Pair l = null;
        if (root.left != null) {
            l = dfs(root.left, depth + 1);
        }
        Pair r = null;
        if (root.right != null) {
            r = dfs(root.right, depth + 1);
        }

        if (l != null && r != null) {
            if (l.depth == r.depth) {
                return new Pair(root, l.depth);
            }else if (l.depth > r.depth) {
                return l;
            }
            return r;
        }else if (l != null) {
            return l;
        }
        return r;
    }
}

