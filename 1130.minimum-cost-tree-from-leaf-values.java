/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 *
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/description/
 *
 * algorithms
 * Medium (59.95%)
 * Likes:    239
 * Dislikes: 24
 * Total Accepted:    7K
 * Total Submissions: 11.5K
 * Testcase Example:  '[6,2,4]'
 *
 * Given an array arr of positive integers, consider all binary trees such
 * that:
 * 
 * 
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order
 * traversal of the tree.  (Recall that a node is a leaf if and only if it has
 * 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf
 * value in its left and right subtree respectively.
 * 
 * 
 * Among all possible binary trees considered, return the smallest possible sum
 * of the values of each non-leaf node.  It is guaranteed this sum fits into a
 * 32-bit integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the
 * second has non-leaf node sum 32.
 * 
 * ⁠   24            24
 * ⁠  /  \          /  \
 * ⁠ 12   4        6    8
 * ⁠/  \               / \
 * 6    2             2   4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * It is guaranteed that the answer fits into a 32-bit signed integer (ie. it
 * is less than 2^31).
 * 
 */

// @lc code=start
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][][] f = new int[n][n][2];
        for (int i = 0; i < n; ++i) {
            f[i][i][0] = 0;
            f[i][i][1] = arr[i];
        }
        
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                
                int minSum = Integer.MAX_VALUE;
                int maxLeaf = 0;
                for (int k = i; k < j; ++k) {
                    int sum = f[i][k][0] + f[k + 1][j][0] + f[i][k][1] * f[k + 1][j][1];
                    if (sum < minSum) {
                        minSum = sum;
                        maxLeaf = Math.max(f[i][k][1], f[k + 1][j][1]);
                    }
                }
                f[i][j][0] = minSum;
                f[i][j][1] = maxLeaf;
            }
        }
        return f[0][n - 1][0];
    }
}
// @lc code=end

