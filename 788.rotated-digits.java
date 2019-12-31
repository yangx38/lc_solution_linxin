/*
 * @lc app=leetcode id=788 lang=java
 *
 * [788] Rotated Digits
 *
 * https://leetcode.com/problems/rotated-digits/description/
 *
 * algorithms
 * Easy (55.29%)
 * Likes:    236
 * Dislikes: 798
 * Total Accepted:    34.2K
 * Total Submissions: 61.7K
 * Testcase Example:  '10'
 *
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X.  Each digit must be rotated
 * - we cannot choose to leave it alone.
 * 
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8
 * rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each
 * other, and the rest of the numbers do not rotate to any other number and
 * become invalid.
 * 
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * 
 * 
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: 
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after
 * rotating.
 * 
 * 
 * Note:
 * 
 * 
 * N  will be in range [1, 10000].
 * 
 * 
 */
class Solution {
    String x = "0125689";
    public int rotatedDigits(int N) {
        int cnt = 0;
        for (int num = 1; num <= N; ++num) {
            if (isValid(num)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    
    private boolean isValid(int num) {
        boolean res = false;
        
        while (num > 0) {
            int r = num % 10;
            if (x.indexOf((char)(r + '0')) == -1) {
                return false;
            }
            if (r == 2 || r == 5 || r == 6 || r == 9) {
                res = true;
            }
            num /= 10;
        }
        return res;
    }
}

