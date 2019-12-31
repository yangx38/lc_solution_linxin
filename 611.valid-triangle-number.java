/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 *
 * https://leetcode.com/problems/valid-triangle-number/description/
 *
 * algorithms
 * Medium (46.21%)
 * Likes:    701
 * Dislikes: 81
 * Total Accepted:    44.5K
 * Total Submissions: 96.3K
 * Testcase Example:  '[2,2,3,4]'
 *
 * Given an array consists of non-negative integers,  your task is to count the
 * number of triplets chosen from the array that can make triangles if we take
 * them as side lengths of a triangle.
 * 
 * Example 1:
 * 
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are: 
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 * 
 * 
 * 
 */
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 0;
        for (int i = n - 1; i >= 2; --i) {
            for (int l = 0, r = i - 1; l < r; --r) {
                while (l < r && nums[l] + nums[r] <= nums[i]) {
                    l++;
                }
                
                if (l < r && nums[l] + nums[r] > nums[i]) {
                    cnt += r - l;
                }
            }
        }
        return cnt;
    }
}

