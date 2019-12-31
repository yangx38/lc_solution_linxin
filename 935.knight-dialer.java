/*
 * @lc app=leetcode id=935 lang=java
 *
 * [935] Knight Dialer
 *
 * https://leetcode.com/problems/knight-dialer/description/
 *
 * algorithms
 * Medium (41.89%)
 * Likes:    293
 * Dislikes: 101
 * Total Accepted:    17.6K
 * Total Submissions: 42K
 * Testcase Example:  '1'
 *
 * A chess knight can move as indicated in the chess diagram below:
 * 
 * .           
 * 
 * 
 * 
 * This time, we place our chess knight on any numbered key of a phone pad
 * (indicated above), and the knight makes N-1 hops.  Each hop must be from one
 * key to another numbered key.
 * 
 * Each time it lands on a key (including the initial placement of the knight),
 * it presses the number of that key, pressing N digits total.
 * 
 * How many distinct numbers can you dial in this manner?
 * 
 * Since the answer may be large, output the answer modulo 10^9 + 7.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: 10
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2
 * Output: 20
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 3
 * Output: 46
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 5000
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int knightDialer(int K) {
        int[][][] f = new int[4][3][K + 1];
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 3; ++j) {
                f[i][j][1] = 1;
            }
        }

        int mod = 1000000007;
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        for (int k = 2; k <= K; ++k) {
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 3; ++j) {
                    f[i][j][k] = 0;
                    int t = 0;

                    for (int d = 0; d < 8; ++d) {
                        int x = i + dx[d];
                        int y = j + dy[d];
                        if ((x == 3 && y == 1) || (x >= 0 && x < 3 && y >= 0 && y < 3)) {
                            t += f[x][y][k - 1];
                            t %= mod;
                        }
                    }
                    f[i][j][k] += t;
                    f[i][j][k] %= mod;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                res = (res + f[i][j][K]) % mod;
            }
        }
        return (res + f[3][1][K]) % mod;
    }
}

