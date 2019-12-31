/*
 * @lc app=leetcode id=1042 lang=java
 *
 * [1042] Flower Planting With No Adjacent
 *
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/description/
 *
 * algorithms
 * Easy (48.01%)
 * Likes:    121
 * Dislikes: 154
 * Total Accepted:    10.6K
 * Total Submissions: 22.2K
 * Testcase Example:  '3\n[[1,2],[2,3],[3,1]]'
 *
 * You have N gardens, labelled 1 to N.  In each garden, you want to plant one
 * of 4 types of flowers.
 * 
 * paths[i] = [x, y] describes the existence of a bidirectional path from
 * garden x to garden y.
 * 
 * Also, there is no garden that has more than 3 paths coming into or leaving
 * it.
 * 
 * Your task is to choose a flower type for each garden such that, for any two
 * gardens connected by a path, they have different types of flowers.
 * 
 * Return any such a choice as an array answer, where answer[i] is the type of
 * flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2,
 * 3, or 4.  It is guaranteed an answer exists.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: N = 3, paths = [[1,2],[2,3],[3,1]]
 * Output: [1,2,3]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: N = 4, paths = [[1,2],[3,4]]
 * Output: [1,2,1,2]
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * Output: [1,2,3,4]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * No garden has 4 or more paths coming into or leaving it.
 * It is guaranteed an answer exists.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; ++i) {
            map.put(i, new ArrayList<>());
        }
        for (int[] path: paths) {
            int u = path[0], v = path[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }

        int[] color = new int[N];
        for (int i = 1; i <= N; ++i) {
            for (int c = 1; c <= 4; ++c) {
                boolean isValid = true;
                for (int nei: map.get(i)) {
                    if (color[nei - 1] == c) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    color[i - 1] = c;
                }
            }
        }
        return color;
    }
}

