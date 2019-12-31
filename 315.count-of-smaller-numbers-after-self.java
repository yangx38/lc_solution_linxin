/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 *
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (39.32%)
 * Likes:    1410
 * Dislikes: 62
 * Total Accepted:    89.8K
 * Total Submissions: 227.8K
 * Testcase Example:  '[5,2,6,1]'
 *
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * 
 * Input: [5,2,6,1]
 * Output: [2,1,1,0] 
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * 
 */
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] a = nums.clone();
        Arrays.sort(a);
        Map<Integer, Integer> map = new HashMap<>();
        int n = a.length;
        int rank = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || a[i] != a[i - 1]) {
                map.put(a[i], rank++);
            }
        }

        FenwickTree tree = new FenwickTree(rank);
        List<Integer> res = new LinkedList<>();
        for (int i = n - 1; i >= 0; --i) {
            int r = map.get(nums[i]);
            int cnt = tree.query(r - 1);
            res.add(0, cnt);
            tree.update(r, 1);
        }
        return res;
    }
}

class FenwickTree{
    int[] bit;
    FenwickTree(int n) {
        bit = new int[n + 1];
    }

    private int lowbit(int x) {
        return x&(-x);
    }

    public int query(int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= lowbit(i)) {
            sum += bit[i];
        }
        return sum;
    }

    public void update(int index, int delta) {
        for (int i = index + 1; i < bit.length; i += lowbit(i)) {
            bit[i] += delta;
        }
    }
}

