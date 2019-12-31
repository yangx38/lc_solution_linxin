/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 *
 * https://leetcode.com/problems/single-number-iii/description/
 *
 * algorithms
 * Medium (58.17%)
 * Likes:    995
 * Dislikes: 81
 * Total Accepted:    116.2K
 * Total Submissions: 199.4K
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * 
 * Note:
 * 
 * 
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 * 
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int a = 0;
        for (int num: nums) {
            a ^= num;
        }

        //a = x ^ y;
        int pos = 0;
        for (int i = 0; i < 32; ++i) {
            if (((a >> i) & 1) == 1) {
                pos = i;
                break;
            }
        }

        int c = 0, d = 0;
        for (int num: nums) {
            if (((num >> pos) & 1) == 1) {
                c ^= num;
            }else {
                d ^= num;
            }
        }
        return new int[]{c, d};
    }
}
// @lc code=end

