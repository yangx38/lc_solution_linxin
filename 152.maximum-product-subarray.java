/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (30.02%)
 * Likes:    2570
 * Dislikes: 115
 * Total Accepted:    246.9K
 * Total Submissions: 819.2K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], ans = nums[0];
        
        
        for (int i = 1; i < nums.length; ++i) {
            int prevMin = min;
            min = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            max = Math.max(nums[i], Math.max(max * nums[i], prevMin * nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
// @lc code=end

