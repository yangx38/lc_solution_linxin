/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 *
 * https://leetcode.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (16.10%)
 * Likes:    576
 * Dislikes: 1514
 * Total Accepted:    130.8K
 * Total Submissions: 810.1K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int n = points.length;
        int max = 1;
        for (int i = 0; i < n; ++i) {
            Map<String, Integer> map = new HashMap<>();
            int samePoints = 1;
            int x1 = points[i][0], y1 = points[i][1];

            for (int j = i + 1; j < n; ++j) {
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    samePoints++;
                    continue;
                }

                int dx = x1 - x2;
                int dy = y1 - y2;
                int gcd = getGCD(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String slope = dx + " " + dy;
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }
            int curMax = samePoints;
            for (String slope: map.keySet()) {
                curMax = Math.max(curMax, map.get(slope) + samePoints);
            }
            max = Math.max(max, curMax);
        }
        return max;
    }

    private int getGCD(int a, int b) {
        return b == 0 ? a: getGCD(b, a % b);
    }
}
// @lc code=end

