/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (41.43%)
 * Likes:    3003
 * Dislikes: 69
 * Total Accepted:    262.5K
 * Total Submissions: 633.1K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4. 
 * 
 * Note: 
 * 
 * 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n^2) complexity.
 * 
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0, n = nums.length;
        for (int r = 1; r < n; ++r) {
            if (nums[r] > nums[l]) {
                nums[++l] = nums[r];
            }else {
                int index = smallestElementGreaterThanOrEqualTo(nums, l, nums[r]);
                nums[index] = nums[r];
            }
        }
        return l + 1;
    }

    private int smallestElementGreaterThanOrEqualTo(int[] nums, int right, int target) {
        int l = 0, r = right;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}

