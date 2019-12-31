/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (54.13%)
 * Likes:    1985
 * Dislikes: 173
 * Total Accepted:    437.9K
 * Total Submissions: 807.7K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, cnt = 0;
        for (int num: nums) {
            if (num == candidate) {
                cnt++;
            }else {
                cnt--;
                if (cnt == -1) {
                    candidate = num;
                    cnt = 1;
                }
            }
        }
        return candidate;
    }
}

