/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (56.56%)
 * Likes:    2830
 * Dislikes: 243
 * Total Accepted:    314.4K
 * Total Submissions: 553.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array nums of n integers where n > 1,  return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does
 * not count as extra space for the purpose of space complexity analysis.)
 * 
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int p = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = p;
            p *= nums[i];
        }
        
        int q = 1;
        for (int i = n - 1; i >= 0; --i) {
            res[i] *= q;
            q *= nums[i];
        } 
        return res;
    }
}
// @lc code=end

