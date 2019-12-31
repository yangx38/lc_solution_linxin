/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 *
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (20.11%)
 * Likes:    753
 * Dislikes: 749
 * Total Accepted:    100.9K
 * Total Submissions: 501.5K
 * Testcase Example:  '[1,2,3,1]\n3\n0'
 *
 * Given an array of integers, find out whether there are two distinct indices
 * i and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // if (nums == null || nums.length <= 1 || k <= 0 || t < 0) {
        //     return false;
        // }

        // TreeSet<Integer> set = new TreeSet<>();

        // for (int i = 0; i < nums.length; ++i) {
        //     Integer ceil = set.ceiling(nums[i]);
        //     if (ceil != null && (long)ceil - nums[i] <= t) {
        //         return true;
        //     }

        //     Integer floor = set.floor(nums[i]);
        //     if (floor != null && (long)nums[i] - floor <= t) {
        //         return true;
        //     }
        //     set.add(nums[i]);
        //     if (i >= k) {
        //         set.remove(nums[i - k]);
        //     }
        // }
        // return false;
        if (nums == null || nums.length <= 1 || k <= 0 || t < 0) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
        }

        Map<Long, Integer> bucket = new HashMap<>();
        long diff = (long)t + 1;

        for (int i = 0; i < nums.length; ++i) {
            if (bucket.containsKey(((long)nums[i] - min) / diff)) {
                return true;
            }
            Integer left_bucket = bucket.get(((long)nums[i] - min) / diff - 1);
            if (left_bucket != null && (long)nums[i] - left_bucket <= t) {
                return true;
            }
            Integer right_bucket = bucket.get(((long)nums[i] - min) / diff + 1);
            if (right_bucket != null && (long)right_bucket - nums[i] <= t) {
                return true;
            }
            
        }

    }
}

