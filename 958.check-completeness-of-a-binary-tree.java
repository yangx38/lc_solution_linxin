/*
 * @lc app=leetcode id=958 lang=java
 *
 * [958] Check Completeness of a Binary Tree
 *
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (48.70%)
 * Likes:    342
 * Dislikes: 7
 * Total Accepted:    23K
 * Total Submissions: 47.1K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a binary tree, determine if it is a complete binary tree.
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2^h nodes inclusive at the last level
 * h.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with
 * node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are
 * as far left as possible.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The tree will have between 1 and 100 nodes.
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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left == null)  {
                    flag = true;
                }else {
                    if (flag) return false;
                    q.offer(cur.left);
                }

                if (cur.right == null) {
                    flag = true;
                }else {
                    if (flag) return false;
                    q.offer(cur.right);
                }
            }
        }
        return true;
    }
}

