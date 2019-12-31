/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (33.17%)
 * Likes:    2972
 * Dislikes: 360
 * Total Accepted:    484.1K
 * Total Submissions: 1.5M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int l = 0 , r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] <= nums[r]) r = mid;
            else l = mid + 1;
        }

        //nums[l] == minVal;
        if (target > nums[n - 1]) {
            r = l - 1;
            l = 0;
        }else {
            r = n - 1;
        }

        while (l < r) {
            int mid = l + r + 1>> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return nums[l] == target ? l: -1;
    }
}

