/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 *
 * https://leetcode.com/problems/distant-barcodes/description/
 *
 * algorithms
 * Medium (39.76%)
 * Likes:    157
 * Dislikes: 10
 * Total Accepted:    7.7K
 * Total Submissions: 19.3K
 * Testcase Example:  '[1,1,1,2,2,2]'
 *
 * In a warehouse, there is a row of barcodes, where the i-th barcode is
 * barcodes[i].
 * 
 * Rearrange the barcodes so that no two adjacent barcodes are equal.  You may
 * return any answer, and it is guaranteed an answer exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,1,1,2,2,2]
 * Output: [2,1,2,1,2,1]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,2,1,2,1]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] cnt = new int[10001];
        for (int barcode: barcodes) {
            cnt[barcode]++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (cnt[a] != cnt[b]) {
                    return cnt[a] < cnt[b] ? 1: -1;
                }
                return a < b ? 1: -1;
            }
        });

        for (int i = 1; i <= 10000; ++i) {
            if (cnt[i] > 0) {
                maxHeap.offer(i);
            }
        }

        int index = 0;
        int[] res = new int[barcodes.length];
        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            res[index++] = x;
            int y = maxHeap.poll();
            res[index++] = y;

            if (--cnt[x] > 0) {
                maxHeap.offer(x);
            }
            if (--cnt[y] > 0) {
                maxHeap.offer(y);
            }
        }

        if (maxHeap.size() == 1) {
            res[index++] = maxHeap.poll();
        }
        return res;
    }
}

