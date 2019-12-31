/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (36.85%)
 * Likes:    428
 * Dislikes: 423
 * Total Accepted:    140.9K
 * Total Submissions: 381.9K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * 
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 * 
 * 
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int n = nums.length;
        for (int r = 0; r < n; ++r) {
            int left = nums[r];
            while (r + 1 < n && nums[r + 1] == nums[r] + 1) {
                r++;
            }
            addRange(res, left, nums[r]);
        }
        return res;
    }

    private void addRange(List<String> res, int start, int end) {
        if (start == end) {
            res.add("" + start);
            return;
        }
        res.add(start + "->" + end);
    }
}

