/*
 * @lc app=leetcode id=1093 lang=java
 *
 * [1093] Statistics from a Large Sample
 *
 * https://leetcode.com/problems/statistics-from-a-large-sample/description/
 *
 * algorithms
 * Medium (44.20%)
 * Likes:    29
 * Dislikes: 156
 * Total Accepted:    5.1K
 * Total Submissions: 11.5K
 * Testcase Example:  '[0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]'
 *
 * We sampled integers between 0 and 255, and stored the results in an array
 * count:  count[k] is the number of integers we sampled equal to k.
 * 
 * Return the minimum, maximum, mean, median, and mode of the sample
 * respectively, as an array of floating point numbers.  The mode is guaranteed
 * to be unique.
 * 
 * (Recall that the median of a sample is:
 * 
 * 
 * The middle element, if the elements of the sample were sorted and the number
 * of elements is odd;
 * The average of the middle two elements, if the elements of the sample were
 * sorted and the number of elements is even.)
 * 
 * 
 * 
 * Example 1:
 * Input: count =
 * [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * Output: [1.00000,3.00000,2.37500,2.50000,3.00000]
 * Example 2:
 * Input: count =
 * [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * Output: [1.00000,4.00000,2.18182,2.00000,1.00000]
 * 
 * 
 * Constraints:
 * 
 * 
 * count.length == 256
 * 1 <= sum(count) <= 10^9
 * The mode of the sample that count represents is unique.
 * Answers within 10^-5 of the true value will be accepted as correct.
 * 
 * 
 */
class Solution {
    public double[] sampleStats(int[] count) {
        int min = 0;
        while (count[min] == 0) {
            min++;
        }

        long sum = 0;
        int t = 0;
        int max = 0;
        int mode = 0;
        for (int i = 0; i < 256; ++i) {
            if (count[i] > 0) {
                max = i;
            }
            if (count[i] > count[mode]) {
                mode = i;
            }
            sum += count[i] * i;
            t += count[i];
        }

        int half = t / 2;
        double median = 0;
        int i = 0, x = 0;
        while (x < half) {
            x += count[i++];
        }

        if (t % 2 == 1) {
            median = (double)i - 1;
        }else {
            int l = i - 1, r = i - 1;
            if (x == half) {
                r++;
            }
            median = ((double)r + l) / 2.0;
        }

        double[] res = new double[5];
        res[0] = (double)min;
        res[1] = (double)max;
        res[2] = (double)sum / t;
        res[3] = median;
        res[4] = (double)mode;
        return res;
    }
}

