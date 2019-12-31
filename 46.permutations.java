/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (57.42%)
 * Likes:    2473
 * Dislikes: 79
 * Total Accepted:    441.9K
 * Total Submissions: 766.4K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        dfs(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> list,
    List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, visited, list, res);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
// @lc code=end

