/*
 * @lc app=leetcode id=1104 lang=java
 *
 * [1104] Path In Zigzag Labelled Binary Tree
 *
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/description/
 *
 * algorithms
 * Medium (70.45%)
 * Likes:    113
 * Dislikes: 91
 * Total Accepted:    8.2K
 * Total Submissions: 11.7K
 * Testcase Example:  '14'
 *
 * In an infinite binary tree where every node has two children, the nodes are
 * labelled in row order.
 * 
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling
 * is left to right, while in the even numbered rows (second, fourth,
 * sixth,...), the labelling is right to left.
 * 
 * 
 * 
 * Given the label of a node in this tree, return the labels in the path from
 * the root of the tree to the node with that label.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: label = 14
 * Output: [1,3,4,14]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: label = 26
 * Output: [1,2,6,10,26]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= label <= 10^6
 * 
 * 
 */
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        if (label == 1) return Collections.singletonList(1);
        List<Integer> output = new ArrayList<>();
        int levelWidth = 1, depth = 0;
        while (levelWidth <= label/2) {
            levelWidth *= 2;
            depth++;
        }
        int distEdge = (depth % 2 == 0) ? (label - levelWidth) : (2 * levelWidth - 1 - label);
        while(depth > 0) {
            if(depth % 2 == 0) output.add(0, levelWidth + distEdge);
            else output.add(0, 2 * levelWidth - 1 - distEdge);
            depth--;
            levelWidth /= 2;
            distEdge = (distEdge > 1) ? distEdge/2 : 0;
        }
        output.add(0, 1);
        return output;
    }
}

