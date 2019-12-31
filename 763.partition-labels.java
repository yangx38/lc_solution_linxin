/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 *
 * https://leetcode.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (72.16%)
 * Likes:    1274
 * Dislikes: 67
 * Total Accepted:    69.7K
 * Total Submissions: 96.4K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * 
 * A string S of lowercase letters is given.  We want to partition this string
 * into as many parts as possible so that each letter appears in at most one
 * part, and return a list of integers representing the size of these parts.
 * 
 * 
 * Example 1:
 * 
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits S into less parts.
 * 
 * 
 * 
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return list;
        }

        int[] index = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            index[s.charAt(i) - 'a'] = i;
        }

        int rightMost = 0, start = 0;
        for (int i = 0; i < n; ++i) {
            rightMost = Math.max(rightMost, index[s.charAt(i) - 'a']);
            if (rightMost == i) {
                list.add(i - start + 1);
                start = i + 1;
            }
        }
        return list;
    }
}
// @lc code=end

