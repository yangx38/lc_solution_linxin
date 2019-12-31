/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 *
 * https://leetcode.com/problems/split-array-largest-sum/description/
 *
 * algorithms
 * Hard (42.87%)
 * Likes:    1022
 * Dislikes: 58
 * Total Accepted:    57.6K
 * Total Submissions: 133.9K
 * Testcase Example:  '[7,2,5,10,8]\n2'
 *
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an
 * algorithm to minimize the largest sum among these m subarrays.
 * 
 * 
 * Note:
 * If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 
 * 
 * 
 * Examples: 
 * 
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * 
 * Output:
 * 18
 * 
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        int l = 0 , r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int group = cntGroup(nums, mid);
            if (group <= m) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    
    private int cntGroup(int[] nums, int limit) {
        int cnt = 0;
        int sum = 0;
        
        for (int num: nums) {
            if (num > limit) {
                return Integer.MAX_VALUE;   
            }
            if (sum + num <= limit) {
                sum += num;
            }else {
                sum = num;
                cnt++;
            }
        }
        return cnt + 1;
    }
}
// @lc code=end

