/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 *
 * https://leetcode.com/problems/delete-nodes-and-return-forest/description/
 *
 * algorithms
 * Medium (63.67%)
 * Likes:    299
 * Dislikes: 6
 * Total Accepted:    13.3K
 * Total Submissions: 20.9K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n[3,5]'
 *
 * Given the root of a binary tree, each node in the tree has a distinct
 * value.
 * 
 * After deleting all nodes with a value in to_delete, we are left with a
 * forest (a disjoint union of trees).
 * 
 * Return the roots of the trees in the remaining forest.  You may return the
 * result in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> dSet = new HashSet<>();
        for (int node: to_delete) {
            dSet.add(node);
        }
        
        List<TreeNode> res = new ArrayList<>();
        dfs(root, dSet, res);
        if (root != null && !dSet.contains(root.val)) {
            res.add(root);
        }
        return res;
    }
    
    private void dfs(TreeNode root, Set<Integer> dSet, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, dSet, res);
        dfs(root.right, dSet, res);
        
        if (root.left != null && dSet.contains(root.left.val)) {
            root.left = null;
        }
        if (root.right != null && dSet.contains(root.right.val)) {
            root.right = null;
        }
        if (dSet.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
        }
    }
}

