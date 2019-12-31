/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (31.82%)
 * Likes:    2270
 * Dislikes: 83
 * Total Accepted:    246.5K
 * Total Submissions: 772K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;

        for (int coin: coins) {
            for (int w = coin; w <= amount; ++w) {
                if (f[w - coin] != Integer.MAX_VALUE && f[w - coin] + 1 < f[w]) {
                    f[w] = f[w - coin] + 1;
                }
            }
        }
        return f[amount] == Integer.MAX_VALUE ? -1: f[amount];
    }
}
// @lc code=end

