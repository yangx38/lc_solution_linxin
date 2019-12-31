/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (27.17%)
 * Likes:    4894
 * Dislikes: 700
 * Total Accepted:    494.8K
 * Total Submissions: 1.8M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        if (l % 2 == 1) {
            return (double)findKthLargestElement(nums1, 0, nums2, 0, l / 2 + 1);
        }else{
           int a = findKthLargestElement(nums1, 0, nums2, 0, l / 2 + 1); 
            int b = findKthLargestElement(nums1, 0, nums2, 0, l / 2);
            System.out.println(a + "," + b);
            return (0.0 + a + b) / 2;
        }
    }

    private int findKthLargestElement(int[] A, int startA, int[] B, int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        } 
        if (startB >= B.length) {
            return A[startA + k - 1];
        }

        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }

        int halfKthOfA = startA + k / 2 - 1 >= A.length ? Integer.MAX_VALUE: A[startA + k / 2 - 1];
        int halfKthOfB = startB + k / 2 - 1>= B.length ? Integer.MAX_VALUE : B[startB + k / 2 - 1];
        if (halfKthOfA <= halfKthOfB) {
            return findKthLargestElement(A, startA + k / 2, B, startB, k - k / 2);
        }
        return findKthLargestElement(A, startA, B, startB + k / 2, k - k / 2);
    }
}

