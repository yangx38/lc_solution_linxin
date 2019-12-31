/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 *
 * https://leetcode.com/problems/integer-replacement/description/
 *
 * algorithms
 * Medium (31.87%)
 * Likes:    244
 * Dislikes: 262
 * Total Accepted:    45.2K
 * Total Submissions: 141.4K
 * Testcase Example:  '8'
 *
 * 
 * Given a positive integer n and you can do operations as follow:
 * 
 * 
 * 
 * 
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * 
 * 
 * 
 * 
 * What is the minimum number of replacements needed for n to become 1?
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 8
 * 
 * Output:
 * 3
 * 
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 7
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int integerReplacement(int n) {
        Map<Long, Integer> map = new HashMap<>();
        return dp(n, map);
    }
    
    private int dp(long n, Map<Long, Integer> map) {
        if (n == 1) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        
        if (n % 2 == 0) {
            return dp(n / 2, map) + 1;
        }
        
        int res = Integer.MAX_VALUE;
        res = Math.min(dp(n + 1, map), dp(n - 1, map)) + 1;
        map.put(n, res);
        return res;
    }
}
// @lc code=end

