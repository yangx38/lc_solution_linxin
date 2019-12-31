/*
 * @lc app=leetcode id=818 lang=java
 *
 * [818] Race Car
 *
 * https://leetcode.com/problems/race-car/description/
 *
 * algorithms
 * Hard (36.36%)
 * Likes:    338
 * Dislikes: 38
 * Total Accepted:    12.8K
 * Total Submissions: 35.1K
 * Testcase Example:  '3'
 *
 * Your car starts at position 0 and speed +1 on an infinite number line.
 * (Your car can go into negative positions.)
 * 
 * Your car drives automatically according to a sequence of instructions A
 * (accelerate) and R (reverse).
 * 
 * When you get an instruction "A", your car does the following: position +=
 * speed, speed *= 2.
 * 
 * When you get an instruction "R", your car does the following: if your speed
 * is positive then speed = -1 , otherwise speed = 1.  (Your position stays the
 * same.)
 * 
 * For example, after commands "AAR", your car goes to positions 0->1->3->3,
 * and your speed goes to 1->2->4->-1.
 * 
 * Now for some target position, say the length of the shortest sequence of
 * instructions to get there.
 * 
 * 
 * Example 1:
 * Input: 
 * target = 3
 * Output: 2
 * Explanation: 
 * The shortest instruction sequence is "AA".
 * Your position goes from 0->1->3.
 * 
 * 
 * 
 * Example 2:
 * Input: 
 * target = 6
 * Output: 5
 * Explanation: 
 * The shortest instruction sequence is "AAARA".
 * Your position goes from 0->1->3->7->7->6.
 * 
 * 
 * 
 * 
 * Note: 
 * 
 * 
 * 1 <= target <= 10000.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int racecar(int t) {
        int[][][] f = new int[t * 2 + 1][17][2];
        for (int i = 0; i <= 2 * t; ++i) {
            for (int j = 0; j < 17; ++j) {
                for (int k = 0; k < 2; ++k) {
                    f[i][j][k] = 0x3f3f3f3f;
                } 
            }
        }
        
        f[0][0][0] = 0;
        
        Queue<Pair> q = new LinkedList<>();
        //0 ->, 1 <-
        q.offer(new Pair(0, 0, 0));
        
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            // System.out.println(cur.pos + "," + cur.v);
            int pos = cur.pos;
            if (pos == t) {
                return f[pos][cur.v][cur.dir];
            }
            
            int speed = 1 << cur.v;
            if (cur.dir == 1) {
                speed = -speed;
            }
            
            //'A'
            if (pos + speed <= t * 2 && pos + speed >= 0) {
                Pair next = new Pair(cur.pos + speed, cur.v + 1, cur.dir);
                if (f[next.pos][next.v][next.dir] > f[cur.pos][cur.v][cur.dir] + 1) {
                    f[next.pos][next.v][next.dir] = f[cur.pos][cur.v][cur.dir] + 1;
                    q.offer(next);
                }
            }
            
            //'R';
            Pair next = new Pair(cur.pos, 0, 1 - cur.dir);
            if (f[next.pos][next.v][next.dir] > f[cur.pos][cur.v][cur.dir] + 1) {
                f[next.pos][next.v][next.dir] = f[cur.pos][cur.v][cur.dir] + 1;
                q.offer(next);
            }
            
        }
        return -1;
    }
}

class Pair{
    int pos, v, dir;
    Pair(int pos, int v, int dir) {
        this.pos = pos;
        this.v = v;
        this.dir = dir;
    }
}
// @lc code=end

