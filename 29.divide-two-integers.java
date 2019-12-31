/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.15%)
 * Likes:    788
 * Dislikes: 3808
 * Total Accepted:    218K
 * Total Submissions: 1.3M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * 
 * Note:
 * 
 * 
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 2^31 − 1 when the
 * division result overflows.
 * 
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long dd = dividend;
        long ds = divisor;

        int sign = 1;
        if (dd < 0) {
            sign = -sign;
            dd = -dd;
        }
        if (ds < 0) {
            sign = -sign;
            ds = -ds;
        }

        int res = 0;
        while (dd >= ds) {
            int shift = 0;
            while ((ds << shift) <= dd) {
                shift++;
            }

            //ds << shift > dd;
            shift--;
            res += 1<<shift;
            dd -= ds << shift;
        }
        return res * sign;
    }
}

