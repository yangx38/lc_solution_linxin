/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.47%)
 * Likes:    2403
 * Dislikes: 3706
 * Total Accepted:    786K
 * Total Submissions: 3.1M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * 
 */
class Solution {
    public int reverse(int x) {
        int sign =  1;
        long y = x;
        if (x < 0) {
            sign = -1;
            y = -y;
        }

        long res = 0;
        while (y > 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }

        if (res * sign < Integer.MIN_VALUE || res * sign > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)res * sign;
    }
}

