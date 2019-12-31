/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * algorithms
 * Medium (46.65%)
 * Likes:    383
 * Dislikes: 195
 * Total Accepted:    51K
 * Total Submissions: 109.2K
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 * 
 * Given a string and a string dictionary, find the longest string in the
 * dictionary that can be formed by deleting some characters of the given
 * string. If there are more than one possible results, return the longest word
 * with the smallest lexicographical order. If there is no possible result,
 * return the empty string.
 * 
 * Example 1:
 * 
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: 
 * "apple"
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: 
 * "a"
 * 
 * 
 * 
 * Note:
 * 
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.isEmpty() || d == null || d.size() == 0) {
            return "";
        }
        
        Map<Character, List<Integer>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; ++c) {
            map.put(c, new ArrayList<>());
        }
        for (int i = 0; i < s.length(); ++i) {
            map.get(s.charAt(i)).add(i);
        }
        
        
        String ans = "";
        for (String word: d) {
            int start = 0;
            boolean isValid = true;
            
            for (int i = 0; i < word.length(); ++i) {
                start = findSmallestValidIndex(map.get(word.charAt(i)), start);
                if (start == -1) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                if (ans.isEmpty() || word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }
        return ans;
    }
    
    private int findSmallestValidIndex(List<Integer> indexList, int start) {
        if (indexList.isEmpty() || indexList.get(indexList.size() - 1) < start) {
            return -1;
        }
        
        int l = 0 , r = indexList.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (indexList.get(mid) >= start) r = mid;
            else l = mid + 1;
        }
        return indexList.get(l) + 1;
    }
}
// @lc code=end

