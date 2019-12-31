/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (47.10%)
 * Likes:    967
 * Dislikes: 275
 * Total Accepted:    181K
 * Total Submissions: 383.3K
 * Testcase Example:  '[2,2,3,2]'
 *
 * Given a non-empty array of integers, every element appears three times
 * except for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,3,2]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums) {
            for (int i = 0; i <= 31; ++i) {
                bit[i] += ((num >> i) & 1);
            }
        }

        int res = 0;
        for (int i = 0; i <= 31; ++i) {
            if (bit[i] % 3 == 1) {
                res += (1<<i);
            }
        }
        return res;
    }
}
// @lc code=end

