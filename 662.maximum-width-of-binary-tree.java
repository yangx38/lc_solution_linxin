/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
 *
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 *
 * algorithms
 * Medium (39.45%)
 * Likes:    752
 * Dislikes: 152
 * Total Accepted:    39.5K
 * Total Submissions: 100K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * Given a binary tree, write a function to get the maximum width of the given
 * tree. The width of a tree is the maximum width among all levels. The binary
 * tree has the same structure as a full binary tree, but some nodes are null.
 * 
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and right most non-null nodes in the level, where the null nodes
 * between the end-nodes are also counted into the length calculation.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * 
 * ⁠          1
 * ⁠        /   \
 * ⁠       3     2
 * ⁠      / \     \  
 * ⁠     5   3     9 
 * 
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4
 * (5,3,null,9).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        /  
 * ⁠       3    
 * ⁠      / \       
 * ⁠     5   3     
 * 
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2
 * (5,3).
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2 
 * ⁠      /        
 * ⁠     5      
 * 
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length
 * 2 (3,2).
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      /     \  
 * ⁠     5       9 
 * ⁠    /         \
 * ⁠   6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8
 * (6,null,null,null,null,null,null,7).
 * 
 * 
 * 
 * 
 * Note: Answer will in the range of 32-bit signed integer.
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 1;
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0, 0, res);
        for (List<Integer> level: res) {
            if (level.size() > 1) {
                maxWidth = Math.max(maxWidth, level.get(1) - level.get(0) + 1);
            }
        }
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth, int index, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        if (depth == res.size()) {
            res.add(new ArrayList<>());
        }

        List<Integer> list = res.get(depth);
        if (list.size() <= 1) {
            list.add(index);
        }else {
            list.set(1, index);
        }

        dfs(root.left, depth + 1, index * 2, res);
        dfs(root.right, depth + 1, index * 2 + 1, res);
    }
}

