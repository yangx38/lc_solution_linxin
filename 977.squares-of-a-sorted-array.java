/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (71.67%)
 * Likes:    498
 * Dislikes: 53
 * Total Accepted:    109.8K
 * Total Submissions: 153.3K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 * 
 * 
 * 
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        while (i < n && nums[i] < 0) {
            i++;
        }

        //nums[i] >= 0;
        int l = i - 1, r = i;
        int k = 0;
        while (l >= 0 || r < n) {
            if (r == n || (l >= 0 && nums[l] * nums[l] <= nums[r] * nums[r])) {
                res[k++] = nums[l]* nums[l--];
            }else {
                res[k++] = nums[r] * nums[r++];
            }
        }

        return res;
    }
}

