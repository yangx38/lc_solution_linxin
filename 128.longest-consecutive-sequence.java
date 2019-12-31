/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (42.69%)
 * Likes:    2176
 * Dislikes: 116
 * Total Accepted:    231.3K
 * Total Submissions: 541.2K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * 
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        
        int longest = 0;
        for (int num: nums) {
            int l = num - 1, r = num + 1;
            while (set.contains(l)) {
                set.remove(l--);
            }
            while (set.contains(r)) {
                set.remove(r++);
            }
            longest = Math.max(longest, r - l - 1);
        }
        return longest;
    }
}

