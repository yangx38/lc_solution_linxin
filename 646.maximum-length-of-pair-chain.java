/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (49.52%)
 * Likes:    627
 * Dislikes: 56
 * Total Accepted:    41.7K
 * Total Submissions: 84.2K
 * Testcase Example:  '[[1,2], [2,3], [3,4]]'
 *
 * 
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number.
 * 
 * 
 * 
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b
 * < c. Chain of pairs can be formed in this fashion. 
 * 
 * 
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You
 * needn't use up all the given pairs. You can select pairs in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * 
 * 
 * 
 * Note:
 * 
 * The number of given pairs will be in the range [1, 1000].
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        int j = -1;
        int n = pairs.length;
        for (int i = 0; i < n; ++i) {
            if (j == -1 || pairs[i][0] > pairs[j][1]) {
                pairs[++j] = pairs[i];
            }else {
                int index = findSmallestElementGreaterThanOrEqualTo(pairs, j, pairs[i]);
                if ((index == 0 || pairs[i][0] > pairs[index - 1][1]) && pairs[i][1] < pairs[index][1]) {
                    pairs[index] = pairs[i];
                }
            }
        }
        return j + 1;
    }

    private int findSmallestElementGreaterThanOrEqualTo(int[][] pairs, int right, int[] target) {
        int l = 0, r = right;
        while (l < r) {
            int mid = l + r >> 1;
            if (pairs[mid][1] >= target[1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
// @lc code=end

