/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (43.16%)
 * Likes:    2093
 * Dislikes: 58
 * Total Accepted:    257.7K
 * Total Submissions: 595.2K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }

        return constructTree(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }

    private TreeNode constructTree(int[] pre, int pL, int pR, int[] in, int iL, int iR, Map<Integer, Integer> indexMap) {
        if (pL > pR) return null;

        TreeNode root = new TreeNode(pre[pL]);
        if (pL == pR) {
            return root;
        }

        int rootIndex = indexMap.get(root.val);
        int leftSubtreeSize = rootIndex - iL;
        root.left = constructTree(pre, pL + 1, pL + leftSubtreeSize, in, iL, rootIndex - 1, indexMap);
        root.right = constructTree(pre, pL + leftSubtreeSize + 1, pR, in, rootIndex + 1, iR, indexMap);
        return root;
    }
}

