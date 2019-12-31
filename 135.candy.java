/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 *
 * https://leetcode.com/problems/candy/description/
 *
 * algorithms
 * Hard (29.28%)
 * Likes:    610
 * Dislikes: 131
 * Total Accepted:    110.9K
 * Total Submissions: 378.1K
 * Testcase Example:  '[1,0,2]'
 *
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * 
 * 
 * What is the minimum candies you must give?
 * 
 * Example 1:
 * 
 * 
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2,
 * 1, 2 candies respectively.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1,
 * 2, 1 candies respectively.
 * ⁠            The third child gets 1 candy because it satisfies the above two
 * conditions.
 * 
 * 
 */
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);

        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                f[i] = f[i - 1] + 1;
            }
        }

        int sum = f[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1] && f[i] < f[i + 1] + 1) {
                f[i] = f[i + 1] + 1;
            }
            sum += f[i];
        }
        return sum;
    }
}

