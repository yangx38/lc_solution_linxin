/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (26.29%)
 * Likes:    2443
 * Dislikes: 360
 * Total Accepted:    482.6K
 * Total Submissions: 1.8M
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Input: [2,1,3]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * 
 * 
 */

// @lc code=start
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        long prev = (long)Integer.MIN_VALUE - 1;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.val <= prev) {
                return false;
            }
            prev = cur.val;
            if (cur.right != null) {
                TreeNode x = cur.right;
                while (x != null) {
                    stack.push(x);
                    x = x.left;
                }
            }
        }
        return true;
    }
}
// @lc code=end

