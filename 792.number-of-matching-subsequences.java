/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 *
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 *
 * algorithms
 * Medium (44.49%)
 * Likes:    538
 * Dislikes: 42
 * Total Accepted:    24.3K
 * Total Submissions: 54.6K
 * Testcase Example:  '"abcde"\n["a","bb","acd","ace"]'
 *
 * Given string S and a dictionary of words words, find the number of words[i]
 * that is a subsequence of S.
 * 
 * 
 * Example :
 * Input: 
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S:
 * "a", "acd", "ace".
 * 
 * 
 * Note:
 * 
 * 
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 * 
 * 
 */
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; ++c) {
            map.put(c, new ArrayList<>());
        }
        char[] sc = S.toCharArray();
        for (int i = 0; i < sc.length; ++i) {
            map.get(sc[i]).add(i);
        }

        int res = 0;
        for (String word: words) {
            if (findWord(word, map)) {
                res++;
            }
        }
        return res;
    }

    private boolean findWord(String s, Map<Character,List<Integer>> map) {
        int start = 0;
        for (char c: s.toCharArray()) {
            start = binarySearch(start, map.get(c));
            if (start == Integer.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }

    private int binarySearch(int start, List<Integer> list) {
        if (list.isEmpty() || start > list.get(list.size() - 1)) {
            return Integer.MAX_VALUE;
        }

        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= start) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }

        return list.get(l) + 1;
     }
}

