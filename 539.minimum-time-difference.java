/*
 * @lc app=leetcode id=539 lang=java
 *
 * [539] Minimum Time Difference
 *
 * https://leetcode.com/problems/minimum-time-difference/description/
 *
 * algorithms
 * Medium (48.94%)
 * Likes:    297
 * Dislikes: 96
 * Total Accepted:    34K
 * Total Submissions: 69.1K
 * Testcase Example:  '["23:59","00:00"]'
 *
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the
 * minimum minutes difference between any two time points in the list. 
 * 
 * Example 1:
 * 
 * Input: ["23:59","00:00"]
 * Output: 1
 * 
 * 
 * 
 * Note:
 * 
 * The number of time points in the given list is at least 2 and won't exceed
 * 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        
        int n = timePoints.size();
        int res = 1440;
        for (int i = 1; i < n; ++i) {
            res = Math.min(res, diff(timePoints.get(i - 1), timePoints.get(i)));
        }
        
        res = Math.min(res, diff(timePoints.get(0), timePoints.get(n - 1)));
        return res;
    }
    //(00:00,  23:59)    (23:22, 23:31)    (22:10, 23:42)
    private int diff(String t1, String t2) {
        int h1 = Integer.valueOf(t1.substring(0, 2));
        int h2 = Integer.valueOf(t2.substring(0, 2));
        int m1 = Integer.valueOf(t1.substring(3));
        int m2 = Integer.valueOf(t2.substring(3));
        
        int diff1 = h1 * 60 + m1 + (60 - m2) + (24 - h2 - 1) * 60;
        int diff2 = 0;
        if (h1 == h2) {
            diff2 = m2 - m1;
        }else {
            diff2 = 60 - m1 + (h2 - h1 - 1) * 60 + m2;
        }
        return Math.min(diff1, diff2);
    }
}
// @lc code=end

