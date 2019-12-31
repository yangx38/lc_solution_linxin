/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 *
 * https://leetcode.com/problems/dungeon-game/description/
 *
 * algorithms
 * Hard (27.97%)
 * Likes:    833
 * Dislikes: 19
 * Total Accepted:    72.6K
 * Total Submissions: 258.1K
 * Testcase Example:  '[[-2,-3,3],[-5,-10,1],[10,30,-5]]'
 *
 * table.dungeon, .dungeon th, .dungeon td {
 * ⁠ border:3px solid black;
 * }
 * 
 * ⁠.dungeon th, .dungeon td {
 * ⁠   text-align: center;
 * ⁠   height: 70px;
 * ⁠   width: 70px;
 * }
 * 
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health
 * (negative integers) upon entering these rooms; other rooms are either empty
 * (0's) or contain magic orbs that increase the knight's health (positive
 * integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN ->
 * DOWN.
 * 
 * 
 * 
 * 
 * -2 (K)
 * -3
 * 3
 * 
 * 
 * -5
 * -10
 * 1
 * 
 * 
 * 10
 * 30
 * -5 (P)
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight
 * enters and the bottom-right room where the princess is imprisoned.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // health of knight should be at least 1
        
        int m = dungeon.length, n = dungeon[0].length;
        
        int[][] f = new int[m][n];
        f[m - 1][n - 1] = Math.max(1, -dungeon[m - 1][n - 1] + 1);
        
        for (int j = n - 2; j >= 0; --j) {
            f[m - 1][j] = Math.max(1, -dungeon[m - 1][j] + f[m - 1][j + 1]);
        }
        
        for (int i = m - 2; i >= 0; --i) {
            f[i][n - 1] = Math.max(1, -dungeon[i][n - 1] + f[i + 1][n - 1]);
        }
        
        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                f[i][j] = Math.max(1, - dungeon[i][j] + Math.min(f[i + 1][j], f[i][j + 1]));
            }
        }
        return f[0][0];
    }
}
// @lc code=end

