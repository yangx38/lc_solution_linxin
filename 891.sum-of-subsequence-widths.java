/*
 * @lc app=leetcode id=891 lang=java
 *
 * [891] Sum of Subsequence Widths
 *
 * https://leetcode.com/problems/sum-of-subsequence-widths/description/
 *
 * algorithms
 * Hard (29.82%)
 * Likes:    142
 * Dislikes: 81
 * Total Accepted:    5.9K
 * Total Submissions: 19.6K
 * Testcase Example:  '[2,1,3]'
 *
 * Given an array of integers A, consider all non-empty subsequences of A.
 * 
 * For any sequence S, let the width of S be the difference between the maximum
 * and minimum element of S.
 * 
 * Return the sum of the widths of all subsequences of A. 
 * 
 * As the answer may be very large, return the answer modulo 10^9 + 7.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [2,1,3]
 * Output: 6
 * Explanation:
 * Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
 * The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
 * The sum of these widths is 6.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 20000
 * 
 * 
 * 
 */
class Solution {
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        int mod = 1000000007;
        long res = 0, sum = 0, p = 1;
        for (int a: A) {
            res = ((res + a * (p - 1) - sum) % mod + mod) % mod;
            sum = (sum * 2 + a) % mod;
            p = p * 2 % mod;
        }
        return (int)res;
    }
}

