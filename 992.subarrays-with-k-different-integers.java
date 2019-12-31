/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 *
 * https://leetcode.com/problems/subarrays-with-k-different-integers/description/
 *
 * algorithms
 * Hard (45.22%)
 * Likes:    455
 * Dislikes: 9
 * Total Accepted:    10.8K
 * Total Submissions: 23.9K
 * Testcase Example:  '[1,2,1,2,3]\n2'
 *
 * Given an array A of positive integers, call a (contiguous, not necessarily
 * distinct) subarray of A good if the number of different integers in that
 * subarray is exactly K.
 * 
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * 
 * Return the number of good subarrays of A.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2],
 * [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3],
 * [2,1,3], [1,3,4].
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 * 
 */

// @lc code=start
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        //atmostK - atMost K - 1
        
        return subarraysWithAtMostKDistinct(A, K) - subarraysWithAtMostKDistinct(A, K - 1);
    }
    
    private int subarraysWithAtMostKDistinct(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        
        int[] cnt = new int[n + 1];
        
        int unique = 0;
        for (int l = 0, r = 0; r < n; ++r) {
            if (++cnt[nums[r]] == 1) {
                unique++;
            }
            
            while (unique > k) {
                if (--cnt[nums[l++]] == 0) {
                    unique--;
                }
            }
            ans += r - l + 1;
        }
        
        return ans;
    }
}
// @lc code=end

