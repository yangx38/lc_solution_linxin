/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (33.09%)
 * Likes:    1028
 * Dislikes: 124
 * Total Accepted:    112.9K
 * Total Submissions: 340.5K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: [3]
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * 
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0, num2 = 0;
        int cnt1 = 0, cnt2 = 0;

        for (int num: nums) {
            if (num == num1) {
                cnt1++;
            }else if (num == num2) {
                cnt2++;
            }else if (cnt1 == 0) {
                num1 = num;
                cnt1 = 1;
            }else if (cnt2 == 0) {
                num2 = num;
                cnt2 = 1;
            }else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for (int num: nums) {
            if (num == num1) {
                cnt1++;
            }else if (num == num2) {
                cnt2++;
            }
        }
        if (cnt1 * 3 > nums.length) res.add(num1);
        if (cnt2 * 3 > nums.length) res.add(num2);
        return res;
    }
}

