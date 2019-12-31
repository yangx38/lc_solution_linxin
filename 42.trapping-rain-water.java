/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (44.71%)
 * Likes:    4408
 * Dislikes: 79
 * Total Accepted:    344.8K
 * Total Submissions: 771.3K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */
class Solution {
    public int trap(int[] height) {
        int l = 0 , r = height.length - 1;
        while (l < r && height[l + 1] >= height[l]) {
            l++;
        }

        while (l < r && height[r - 1] >= height[r]) {
            r--;
        }

        int water = 0;
        while (l < r) {
            int lb = height[l], rb = height[r];
            if (lb <= rb) {
                l++;
                while (l < r && height[l] <= lb) {
                    water += lb - height[l++];
                }
            }else {
                r--;
                while (l < r && height[r] <= rb) {
                    water += rb - height[r--];
                }
            }
        }
        return water;
    }
}

