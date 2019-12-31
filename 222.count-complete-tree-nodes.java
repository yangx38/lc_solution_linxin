/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (36.81%)
 * Likes:    1227
 * Dislikes: 153
 * Total Accepted:    145.9K
 * Total Submissions: 393.5K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note: 
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2^h nodes inclusive at the last level
 * h.
 * 
 * Example:
 * 
 * 
 * Input: 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \  /
 * 4  5 6
 * 
 * Output: 6
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root.left;
        int l = 0;
        while (left != null) {
            l++;
            left = left.left;
        }

        TreeNode right = root.right;
        int r = 0;
        while (right != null) {
            r++;
            right = right.right;
        }

        if (l == r) {
            return (int)Math.pow(2, l + 1) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

