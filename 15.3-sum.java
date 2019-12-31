/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.76%)
 * Likes:    4492
 * Dislikes: 515
 * Total Accepted:    643.9K
 * Total Submissions: 2.6M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <= n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int l = i + 1, r = n - 1; l < r; ++l) {
                if (l > i + 1 && nums[l] == nums[l - 1]) continue;
                while (l < r && nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                }
                if (l < r && nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}

