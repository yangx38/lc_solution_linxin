/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 *
 * https://leetcode.com/problems/target-sum/description/
 *
 * algorithms
 * Medium (45.79%)
 * Likes:    1628
 * Dislikes: 78
 * Total Accepted:    112.3K
 * Total Submissions: 245.2K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a
 * target, S. Now you have 2 symbols + and -. For each integer, you should
 * choose one from + and - as its new symbol.
 * ⁠
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.  
 * 
 * 
 * Example 1:
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 
 * 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array is positive and will not exceed 20. 
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 * 
 * 
 */
class Solution {
    /*
    sumP - sumN = target
    sumP = target + sumN;
    2 * sumP = target + sumN + sumP;
    2 * sumP = target + totalSum;
    (target + totalSum) % 2 == 0
    find how many ways can sum up to sumP;
    */
    public int findTargetSumWays(int[] nums, int S) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        if ((sum + S) % 2 != 0 || S < -sum || S > sum) {
            return 0;
        }

        return dp(nums, (sum + S) / 2);
    }

    private int dp(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;

        for (int num: nums) {
            for (int t = target; t >= num; --t) {
                f[t] += f[t - num];
            }
        }
        return f[target];
    }
}

