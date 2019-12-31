/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (34.22%)
 * Likes:    2007
 * Dislikes: 96
 * Total Accepted:    353.6K
 * Total Submissions: 1M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (target <= nums[mid]) r = mid;
            else l = mid + 1;
        }

        if (nums[l] != target) {
            return new int[]{-1, -1};
        }

        int[] res = new int[2];
        res[0] = l;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1>> 1;
            if (target >= nums[mid]) l = mid;
            else r = mid - 1;
        }
        res[1] = r;
        return res;
    }
}

