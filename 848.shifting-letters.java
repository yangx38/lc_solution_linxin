/*
 * @lc app=leetcode id=848 lang=java
 *
 * [848] Shifting Letters
 *
 * https://leetcode.com/problems/shifting-letters/description/
 *
 * algorithms
 * Medium (41.96%)
 * Likes:    183
 * Dislikes: 37
 * Total Accepted:    15.8K
 * Total Submissions: 37.6K
 * Testcase Example:  '"abc"\n[3,5,9]'
 *
 * We have a string S of lowercase letters, and an integer array shifts.
 * 
 * Call the shift of a letter, the next letter in the alphabet, (wrapping
 * around so that 'z' becomes 'a'). 
 * 
 * For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
 * 
 * Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x
 * times.
 * 
 * Return the final string after all such shifts to S are applied.
 * 
 * Example 1:
 * 
 * 
 * Input: S = "abc", shifts = [3,5,9]
 * Output: "rpl"
 * Explanation: 
 * We start with "abc".
 * After shifting the first 1 letters of S by 3, we have "dbc".
 * After shifting the first 2 letters of S by 5, we have "igc".
 * After shifting the first 3 letters of S by 9, we have "rpl", the answer.
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length = shifts.length <= 20000
 * 0 <= shifts[i] <= 10 ^ 9
 * 
 * 
 */
class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        int n = S.length();
        int[] diff = new int[n + 1];
        diff[0] = S.charAt(0) -'a';
        for (int i = 1; i < n; ++i) {
            diff[i] = S.charAt(i) - S.charAt(i - 1);
        }
        
        for (int i = 0; i < shifts.length; ++i) {
            int end = i, delta = shifts[i];
            diff[0] += delta;
            diff[0] %= 26;
            diff[end + 1] -= delta;
            int t = (diff[end + 1] % 26 + 26) % 26;
            diff[end + 1] = t;
        }
        
        StringBuilder sb = new StringBuilder();
        char start = (char)(diff[0] % 26 + 'a');
        sb.append(start);
        for (int i = 1; i < n; ++i) {
            diff[i] += diff[i - 1];
            int t = diff[i] % 26;
            char c = (char)('a' + t);
            sb.append(c);
        }
        return sb.toString();
    }
}

