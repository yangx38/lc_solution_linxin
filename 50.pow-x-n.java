/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (28.56%)
 * Likes:    973
 * Dislikes: 2382
 * Total Accepted:    362.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * Example 1:
 * 
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * Note:
 * 
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * 
 * 
 */
class Solution {
    public double myPow(double x, int n) {
        boolean negative  = false;
        long N = n;
        if (N < 0) {
            N = -N;
            negative = true;
        }

        double res = 1.0;
        double k =  x;
        while (N != 0) {
            if ((N&1) == 1) {
                res *= k;
            }
            k *= k;
            N >>= 1;
        }
        if (negative) {
            return 1.0 / res;
        }
        return res;
    }
}

