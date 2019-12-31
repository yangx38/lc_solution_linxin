/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (34.63%)
 * Likes:    1296
 * Dislikes: 57
 * Total Accepted:    163.8K
 * Total Submissions: 473K
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * Say you have an array for which the i^th element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e.,
 * you must sell the stock before you buy again).
 * 
 * Example 1:
 * 
 * 
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit
 * = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 =
 * 3.
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit
 * = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
 * are
 * engaging multiple transactions at the same time. You must sell before buying
 * again.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int n = prices.length;
        
        int[] maxPLeft = new int[n];
        int min = prices[0];
        for (int i = 1; i < n; ++i) {
            maxPLeft[i] = Math.max(maxPLeft[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        int[] maxPRight = new int[n];
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            maxPRight[i] = Math.max(maxPRight[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            int curMax = 0;
            curMax += maxPLeft[i];
            if (i < n - 2) {
                curMax += maxPRight[i + 1];
            }
            ans = Math.max(ans, curMax);
        }
        
        return ans;
    }
}

