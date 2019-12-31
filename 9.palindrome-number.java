/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 ) {
            return false;
        }


        int t = x;
        long y = 0;
        while (t > 0) {
            y = y * 10 + t % 10;
            if (y > Integer.MAX_VALUE) return false;
            t /= 10;
        }
        return (int)y == x;
    }
}

