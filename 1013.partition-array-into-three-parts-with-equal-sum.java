/*
 * @lc app=leetcode id=1013 lang=java
 *
 * [1013] Partition Array Into Three Parts With Equal Sum
 *
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/
 *
 * algorithms
 * Easy (56.16%)
 * Likes:    174
 * Dislikes: 32
 * Total Accepted:    18.1K
 * Total Submissions: 32.3K
 * Testcase Example:  '[0,2,1,-6,6,-7,9,1,2,0,1]'
 *
 * Given an array A of integers, return true if and only if we can partition
 * the array into three non-empty parts with equal sums.
 * 
 * Formally, we can partition the array if we can find indexes i+1 < j with
 * (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1]
 * + ... + A[A.length - 1])
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 3 <= A.length <= 50000
 * -10000 <= A[i] <= 10000
 * 
 */
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num: A) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }

        int each = sum / 3;
        sum = 0;
        int group = 0;
        int i = 0;
        for (i = 0; i < A.length; ++i) {
            if (group == 3) break;
            sum += A[i];
            if (sum == each) {
                sum = 0;
                group++;
            }
        }
        
        if (group < 3) return false;
        if (group == 3) {
            System.out.println("x");
            if (i == A.length) return true;
            for (; i < A.length; ++i) {
                sum += A[i];
            }
            if (sum == 0) return true;
        }

        return false;
    }
}

