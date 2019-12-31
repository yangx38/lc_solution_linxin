/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (33.07%)
 * Likes:    1168
 * Dislikes: 3553
 * Total Accepted:    354.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 */
class Solution {
    public String convert(String s, int n) {
        if (n == 1) {
            return s;
        }

        /*
        n = 4;
        0     6
        1   5 7
        2 4   8 10
        3     9
        */
        StringBuilder sb = new StringBuilder();
        int diff = 2 * n - 2;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || i == n - 1) {
                for (int j = i; j < s.length(); j += diff) {
                    sb.append(s.charAt(j));
                }
            }else {
                for (int j = i, k = diff - i; j < s.length() || k < s.length(); j += diff, k += diff) {
                    if (j < s.length()) sb.append(s.charAt(j));
                    if (k < s.length()) sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }
}

