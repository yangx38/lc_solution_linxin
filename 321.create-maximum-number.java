/*
 * @lc app=leetcode id=321 lang=java
 *
 * [321] Create Maximum Number
 *
 * https://leetcode.com/problems/create-maximum-number/description/
 *
 * algorithms
 * Hard (25.86%)
 * Likes:    461
 * Dislikes: 167
 * Total Accepted:    33K
 * Total Submissions: 127.4K
 * Testcase Example:  '[3,4,6,5]\n[9,1,2,5,8,3]\n5'
 *
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two. The
 * relative order of the digits from the same array must be preserved. Return
 * an array of the k digits.
 * 
 * Note: You should try to optimize your time and space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * 
 * Example 2:
 * 
 * 
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 * 
 * Example 3:
 * 
 * 
 * Input:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * Output:
 * [9, 8, 9]
 * 
 */

// @lc code=start
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        int getFromNums1 = Math.max(nums1.length, k);
        for (int i = Math.max(k - nums2.length, 0); i <= getFromNums1; ++i) {
            int[] res1 = new int[i];
            int[] res2 = new int[k - i];
            int[] res = new int[k];
            res1 = pick(nums1, i);
            res2 = pick(nums2, k - i);
            int pos1 = 0, pos2 = 0, pos = 0;
            while (res1.length > 0 && res2.length > 0 && pos1 < res1.length && pos2 < res2.length) {
                if (compare(res1, pos1, res2, pos2)) {
                    res[pos++] = res1[pos1++];
                }else {
                    res[pos++] = res2[pos2++];
                }
            }
            while (pos1 < res1.length) {
                res[pos++] = res1[pos1++];
            }
            while (pos2 < res2.length) {
                res[pos++] = res2[pos2++];
            }
            if (compare(res, 0, ans, 0)) {
                ans = res;
            }
        }
        return ans;
    }

    private boolean compare(int[] A, int startA, int[] B, int startB) {
        for (; startA < A.length && startB < B.length; startA++, startB++) {
            if (A[startA] > B[startB]) {
                return true;
            }else if (A[startA] < B[startB]) {
                return false;
            }
        }
        return startA != A.length;
    }

    private int[] pick(int[] arr, int k) {
        int l = -1;
        int[] res = new int[k];
        for (int i = 0; i < arr.length; ++i) {
            while (l != -1  && l + arr.length - i >= k && arr[i] > res[l]) {
                l--;
            }
            if (l < k - 1) {
                res[++l] = arr[i];
            }
        }
        return res;
    }
}
// @lc code=end

