/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (c == ']') {
                    if (last != '[') return false;
                }else if (c == '}') {
                    if (last != '{') return false;
                }else if (c == ')') {
                    if (last != '(') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

