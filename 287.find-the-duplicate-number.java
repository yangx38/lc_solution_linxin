/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * algorithms
 * Medium (51.02%)
 * Likes:    2932
 * Dislikes: 339
 * Total Accepted:    222.5K
 * Total Submissions: 435.2K
 * Testcase Example:  '[1,3,4,2,2]'
 *
 * Given an array nums containing n + 1 integers where each integer is between
 * 1 and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,4,2,2]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,1,3,4,2]
 * Output: 3
 * 
 * Note:
 * 
 * 
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n^2).
 * There is only one duplicate number in the array, but it could be repeated
 * more than once.
 * 
 * 
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int l = 1, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            int cnt = cntSmallerThanOrEqualTo(nums, mid);
            if (cnt <= mid) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    private int cntSmallerThanOrEqualTo(int[] nums, int target) {
        int cnt = 0;
        for (int num: nums) {
            if (num <= target) {
                cnt++;
            }
        }
        return cnt;
    }
}

