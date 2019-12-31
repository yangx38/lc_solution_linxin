/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 *
 * algorithms
 * Medium (30.24%)
 * Likes:    842
 * Dislikes: 66
 * Total Accepted:    81.6K
 * Total Submissions: 268.3K
 * Testcase Example:  '["NumArray","sumRange","update","sumRange"]\n[[[1,3,5]],[0,2],[1,2],[0,2]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 * 
 * Example:
 * 
 * 
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 
 * 
 * Note:
 * 
 * 
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is
 * distributed evenly.
 * 
 * 
 */
class NumArray {
    int[] bit;
    int[] arr;
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        bit = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int delta = val - arr[i];
        arr[i] = val;
        for (int j = i + 1; j < bit.length; j += lowbit(j)) {
            bit[j] += delta;
        }
    }
    
    private int lowbit(int x) {
        return x&(-x);
    }

    public int sumRange(int i, int j) {
        return query(j) - query(i - 1);    
    }

    private int query(int index) {
        int sum = 0;
        for (int j = index + 1; j > 0; j -= lowbit(j)) {
            sum += bit[j];
        } 
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

