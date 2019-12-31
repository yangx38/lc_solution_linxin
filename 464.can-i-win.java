/*
 * @lc app=leetcode id=464 lang=java
 *
 * [464] Can I Win
 *
 * https://leetcode.com/problems/can-i-win/description/
 *
 * algorithms
 * Medium (27.89%)
 * Likes:    700
 * Dislikes: 126
 * Total Accepted:    40.9K
 * Total Submissions: 146.3K
 * Testcase Example:  '10\n11'
 *
 * In the "100 game," two players take turns adding, to a running total, any
 * integer from 1..10. The player who first causes the running total to reach
 * or exceed 100 wins. 
 * 
 * What if we change the game so that players cannot re-use integers? 
 * 
 * For example, two players might take turns drawing from a common pool of
 * numbers of 1..15 without replacement until they reach a total >= 100.
 * 
 * Given an integer maxChoosableInteger and another integer desiredTotal,
 * determine if the first player to move can force a win, assuming both players
 * play optimally. 
 * 
 * You can always assume that maxChoosableInteger will not be larger than 20
 * and desiredTotal will not be larger than 300.
 * 
 * 
 * Example
 * 
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 * 
 * Output:
 * false
 * 
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers
 * from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >=
 * desiredTotal.
 * Same with other integers chosen by the first player, the second player will
 * always win.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        int total = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (desiredTotal > total) {
            return false;
        }

        boolean[] f = new boolean[1 << maxChoosableInteger];
        boolean[] r = new boolean[1 << maxChoosableInteger];
        return dfs(maxChoosableInteger, desiredTotal, 0, f, r);
    }

    private boolean dfs(int n, int t, int state, boolean[] f, boolean[] r) {
        if (t <= 0) {
            return false;
        }
        if (f[state]) {
            return r[state];
        }

        f[state] = true;
        for (int i = 0; i < n; ++i) {
            if (((state >> i) & 1) == 0) {
                int next = (1 << i) | state;
                if (!dfs(n, t - i - 1, next, f, r)) {
                    return r[state] = true;
                }
            }
        }
        return r[state] = false;
    }
}
// @lc code=end

