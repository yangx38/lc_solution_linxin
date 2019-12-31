/*
 * @lc app=leetcode id=1007 lang=java
 *
 * [1007] Minimum Domino Rotations For Equal Row
 *
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/
 *
 * algorithms
 * Medium (50.77%)
 * Likes:    127
 * Dislikes: 85
 * Total Accepted:    17.9K
 * Total Submissions: 35K
 * Testcase Example:  '[2,1,2,4,2,2]\n[5,2,6,2,3,2]'
 *
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of
 * the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on
 * each half of the tile.)
 * 
 * We may rotate the i-th domino, so that A[i] and B[i] swap values.
 * 
 * Return the minimum number of rotations so that all the values in A are the
 * same, or all the values in B are the same.
 * 
 * If it cannot be done, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation: 
 * The first figure represents the dominoes as given by A and B: before we do
 * any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the
 * top row equal to 2, as indicated by the second figure.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation: 
 * In this case, it is not possible to rotate the dominoes to make one row of
 * values equal.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 * 
 * 
 */
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int min1 = search(A[0], A, B);
        int min2 = search(B[0], A, B);
        int t = Math.min(min1, min2);
        if (t == Integer.MAX_VALUE) {
            return -1;
        }
        return t;
    }
    
    private int search(int target, int[] A, int[] B) {
        //firstRow;
        int n = A.length;
        int cnt1 = 0;
        for (int i = 0; i < n; ++i) {
            if (A[i] != target) {
                if (B[i] != target) {
                    cnt1 = Integer.MAX_VALUE;
                    break;
                }else {
                    cnt1++;
                }
            }
        }
        
        //secRow;
        int cnt2 = 0;
        for (int i = 0; i < n; ++i) {
            if (B[i] != target) {
                if (A[i] != target) {
                    cnt2 = Integer.MAX_VALUE;
                    break;
                }else {
                    cnt2++;
                }
            }
        }
        return Math.min(cnt1, cnt2);
    }
}

