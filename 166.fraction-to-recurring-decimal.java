/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (19.93%)
 * Likes:    538
 * Dislikes: 1189
 * Total Accepted:    95.6K
 * Total Submissions: 479K
 * Testcase Example:  '1\n2'
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * Example 1:
 * 
 * 
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * 
 * Example 3:
 * 
 * 
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * 
 * 
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long x = numerator, y = denominator;
        boolean negative = false;
        if (x < 0) {
            x = -x;
            negative = !negative;
        }
        if (y < 0) {
            y = -y;
            negative = !negative;
        }
        
        long z = x / y;
        
        if (z * y == x) {
            if (negative && z != 0) {
                return "-" + z;
            }
            return Long.toString(z);
        }
        
        long t = x % y;
        String res = z + ".";
        
        Map<Long, Integer> map = new HashMap<>();
        while (t > 0) {
            t *= 10;
            if (map.containsKey(t)) {
                int index = map.get(t);
                String r = res.substring(index);
                res = res.substring(0, index) + "(" + r + ")";
                break;
            }
            
            long k = t / y;
            map.put(t, res.length());
            res += k;
            t %= y;
        }
        
        if (negative) return '-' + res;
        return res;
    }
}

