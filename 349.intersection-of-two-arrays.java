/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (56.69%)
 * Likes:    481
 * Dislikes: 893
 * Total Accepted:    255.6K
 * Total Submissions: 449.5K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            }else if (nums1[i] > nums2[j]) {
                j++;
            }else {
                list.add(nums1[i]);
                i++;
                j++;
                while (i < nums1.length && nums1[i] == nums1[i - 1]) i++;
                while (j < nums2.length && nums2[j] == nums2[j - 1]) j++;
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int num: list) {
            res[index++] = num;
        }
        return res;
    }
}

