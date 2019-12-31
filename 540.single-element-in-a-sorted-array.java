/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (57.48%)
 * Likes:    875
 * Dislikes: 64
 * Total Accepted:    65.3K
 * Total Submissions: 113.5K
 * Testcase Example:  '[1,1,2,3,3,4,4,8,8]'
 *
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * Find this single element that appears only once.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * 
 * 
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 * 
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }
}
// @lc code=end

