/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 *
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 *
 * algorithms
 * Medium (50.12%)
 * Likes:    1005
 * Dislikes: 18
 * Total Accepted:    33.3K
 * Total Submissions: 66.5K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n2'
 *
 * We are given a binary tree (with root node root), a target node, and an
 * integer value K.
 * 
 * Return a list of the values of all nodes that have a distance K from the
 * target node.  The answer can be returned in any order.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 
 * Output: [7,4,1]
 * 
 * Explanation: 
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * 
 * 
 * 
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these
 * objects.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 * 
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (k < 0) return res;
        if (k == 0) {
            res.add(target.val);
            return res;
        }

        Map<TreeNode, TreeNode> map = new HashMap<>();
        findParent(root, null, map);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        boolean[] visited = new boolean[1001];
        visited[target.val] = true;
        k++;
        while (k-- > 0) {
            res = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                res.add(cur.val);
                if (cur.left != null && !visited[cur.left.val]) {
                    visited[cur.left.val] = true;
                    queue.offer(cur.left);
                }
                if (cur.right != null && !visited[cur.right.val]) {
                    visited[cur.right.val] = true;
                    queue.offer(cur.right);
                }
                TreeNode parent = map.get(cur);
                if (parent != null && !visited[parent.val]) {
                    visited[parent.val] = true;
                    queue.offer(parent);
                }
            }
        }
        return res;
    }

    private void findParent(TreeNode cur, TreeNode p, Map<TreeNode, TreeNode> map) {
        if (cur == null) {
            return;
        }
        map.put(cur, p);
        findParent(cur.left, cur, map);
        findParent(cur.right, cur, map);
    }
}

