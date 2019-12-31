/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 *
 * https://leetcode.com/problems/network-delay-time/description/
 *
 * algorithms
 * Medium (43.92%)
 * Likes:    797
 * Dislikes: 180
 * Total Accepted:    48.9K
 * Total Submissions: 110.5K
 * Testcase Example:  '[[2,1,1],[2,3,1],[3,4,1]]\n4\n2'
 *
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K. How long will it take for all
 * nodes to receive the signal? If it is impossible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] f = new int[N + 1][N + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                f[i][j] = 0x3f3f3f3f;
            }
        }
        
        for (int[] time: times) {
            int u = time[0], v = time[1], cost = time[2];
            f[u][v] = cost;
        }
        for (int i = 1; i <= N; ++i) {
            f[i][i] = 0;
        }
        
        
        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);
                }
            }
        }
        
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; ++i) {
            if (f[K][i] >= 0x3f3f3f3f) {
                return -1;
            }
            ans = Math.max(ans, f[K][i]);
        }
        return ans;
    }
}
// @lc code=end

