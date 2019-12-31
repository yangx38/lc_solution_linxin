/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 *
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 *
 * algorithms
 * Medium (37.46%)
 * Likes:    756
 * Dislikes: 38
 * Total Accepted:    37.1K
 * Total Submissions: 98.9K
 * Testcase Example:  '[10,5,2,6]\n100'
 *
 * Your are given an array of positive integers nums.
 * Count and print the number of (contiguous) subarrays where the product of
 * all the elements in the subarray is less than k.
 * 
 * Example 1:
 * 
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5],
 * [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly
 * less than k.
 * 
 * 
 * 
 * Note:
 * 0 < nums.length .
 * 0 < nums[i] < 1000.
 * 0 .
 * 
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0, n = nums.length;
        for (int p = 1, r = 0, l = 0; r < n; ++r) {
            p *= nums[r];
            while (l <= r && p >= k) {
                p /= nums[l++];
            }
            cnt += r - l + 1;
        }
        return cnt;
    }
}

