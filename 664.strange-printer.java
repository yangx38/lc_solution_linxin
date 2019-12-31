/*
 * @lc app=leetcode id=664 lang=java
 *
 * [664] Strange Printer
 *
 * https://leetcode.com/problems/strange-printer/description/
 *
 * algorithms
 * Hard (37.37%)
 * Likes:    287
 * Dislikes: 37
 * Total Accepted:    10.1K
 * Total Submissions: 27.1K
 * Testcase Example:  '"aaabbb"'
 *
 * 
 * There is a strange printer with the following two special requirements:
 * 
 * 
 * The printer can only print a sequence of the same character each time.
 * At each turn, the printer can print new characters starting from and ending
 * at any places, and will cover the original existing characters.
 * 
 * 
 * 
 * 
 * 
 * Given a string consists of lower English letters only, your job is to count
 * the minimum number of turns the printer needed in order to print it.
 * 
 * 
 * Example 1:
 * 
 * Input: "aaabbb"
 * Output: 2
 * Explanation: Print "aaa" first and then print "bbb".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "aba"
 * Output: 2
 * Explanation: Print "aaa" first and then print "b" from the second place of
 * the string, which will cover the existing character 'a'.
 * 
 * 
 * 
 * Hint: Length of the given string will not exceed 100.
 */
class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();
        int[][] f = new int[n + 1][n + 1];

        for (int len = 1; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                f[i][j] = 1 + f[i + 1][j];

                for (int k = i + 1; k <= j; ++k) {
                    if (s.charAt(k) == s.charAt(i)) {
                        f[i][j] =  Math.min(f[i][j], f[i][k - 1] + f[k + 1][j]);
                    }
                }
            }
        }

        return f[0][n - 1];
    }
}

