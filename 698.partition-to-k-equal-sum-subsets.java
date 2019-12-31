/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 *
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 *
 * algorithms
 * Medium (43.52%)
 * Likes:    1007
 * Dislikes: 57
 * Total Accepted:    53.2K
 * Total Submissions: 122.3K
 * Testcase Example:  '[4,3,2,3,5,2,1]\n4'
 *
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into k non-empty subsets whose sums are all
 * equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3),
 * (2,3) with equal sums.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 * 
 * 
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k <= 0) return false;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        return dfs(0, nums, 0, sum / k, k, new boolean[nums.length]);
    }

    private boolean dfs(int index, int[] nums, int sum, int target, int k, boolean[] visited) {
        if (k == 0) {
            return true;
        }

        if (sum == target) {
            return dfs(0, nums, 0, target, k - 1, visited);
        }

        for (int i = index; i < nums.length; ++i) {
            if (!visited[i] && sum + nums[i] <= target) {
                visited[i] = true;
                if (dfs(i + 1, nums, sum + nums[i], target, k, visited)) {
                    // visited[i] = false;
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}

