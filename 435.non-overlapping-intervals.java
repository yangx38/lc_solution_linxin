/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 *
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 * algorithms
 * Medium (41.90%)
 * Likes:    583
 * Dislikes: 26
 * Total Accepted:    47K
 * Total Submissions: 112.1K
 * Testcase Example:  '[[1,2]]'
 *
 * Given a collection of intervals, find the minimum number of intervals you
 * need to remove to make the rest of the intervals non-overlapping.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are
 * non-overlapping.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals
 * non-overlapping.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You may assume the interval's end point is always bigger than its start
 * point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't
 * overlap each other.
 * 
 * 
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int validCnt = 1;
        int n = intervals.length;
        int lastEnd = intervals[0][1];
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= lastEnd) {
                validCnt++;
                lastEnd = intervals[i][1];
            }else {
                lastEnd = Math.min(lastEnd, intervals[i][1]);
            }
        }
        return n - validCnt;
    }
}

