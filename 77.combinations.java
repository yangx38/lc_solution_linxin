/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (49.77%)
 * Likes:    925
 * Dislikes: 52
 * Total Accepted:    227K
 * Total Submissions: 456.1K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return res;
        }

        dfs(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int cur, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (cur == n + 1 || list.size() + (n - cur + 1) < k) {
            return;
        }

        dfs(cur + 1, n, k, list, res);
        list.add(cur);
        dfs(cur + 1, n, k, list, res);
        list.remove(list.size() - 1);
    }
}

