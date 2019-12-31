/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (43.67%)
 * Likes:    2170
 * Dislikes: 125
 * Total Accepted:    123.3K
 * Total Submissions: 282.4K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, sum, map);
    }

    private int dfs(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        int t = 0;
        sum += root.val;
        if (map.containsKey(sum - target)) {
            t += map.get(sum - target);
        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        t += dfs(root.left, sum, target, map);
        t += dfs(root.right, sum, target, map);

        map.put(sum, map.get(sum) - 1);
        return t;
    }
}

