/*
 * @lc app=leetcode id=1175 lang=java
 *
 * [1175] Prime Arrangements
 *
 * https://leetcode.com/problems/prime-arrangements/description/
 *
 * algorithms
 * Easy (51.13%)
 * Likes:    22
 * Dislikes: 40
 * Total Accepted:    3.8K
 * Total Submissions: 7.5K
 * Testcase Example:  '5'
 *
 * Return the number of permutations of 1 to n so that prime numbers are at
 * prime indices (1-indexed.)
 * 
 * (Recall that an integer is prime if and only if it is greater than 1, and
 * cannot be written as a product of two positive integers both smaller than
 * it.)
 * 
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5
 * Output: 12
 * Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1]
 * is not because the prime number 5 is at index 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 100
 * Output: 682289015
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 100
 * 
 * 
 */
class Solution {
    int mod = 1000000007;
    long[] f;
    public int numPrimeArrangements(int n) {
        f = new long[n + 1];
        Arrays.fill(f, -1);
        f[0] = 1;
        boolean[] isP = new boolean[n + 1];
        Arrays.fill(isP, true);
        for (int i = 2; i * i <= n; ++i) {
            if (isP[i]) {
                for (int j = 2; i * j <= n; ++j) {
                    isP[i * j] = false;
                }
            }
        }

        int p = 0;
        for (int i = 2; i <= n; ++i) {
            if (isP[i]) p++;
        }

        int np = n - p;
        long x = calc(p);
        long y = calc(np);
        long res  = (x * y )% mod;
        return (int)res;
    }

    private long calc(int n) {
        if (f[n] != -1) {
            return f[n];
        }
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] * i;
            f[i] %= mod;
        }
        return f[n];
    }
}

