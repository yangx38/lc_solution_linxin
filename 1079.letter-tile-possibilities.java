/*
 * @lc app=leetcode id=1079 lang=java
 *
 * [1079] Letter Tile Possibilities
 *
 * https://leetcode.com/problems/letter-tile-possibilities/description/
 *
 * algorithms
 * Medium (74.79%)
 * Likes:    285
 * Dislikes: 12
 * Total Accepted:    14K
 * Total Submissions: 18.8K
 * Testcase Example:  '"AAB"'
 *
 * You have a set of tiles, where each tile has one letter tiles[i] printed on
 * it.  Return the number of possible non-empty sequences of letters you can
 * make.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB",
 * "ABA", "BAA".
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "AAABBC"
 * Output: 188
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 * 
 */

// @lc code=start
class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        char[] sc = tiles.toCharArray();
        Arrays.sort(sc);
        
        dfs(sc, new boolean[sc.length], set, new ArrayList<>());
        return set.size();
    }
    
    private void dfs(char[] sc, boolean[] v, Set<String> set, List<Character> list) {
        if (list.size() == sc.length) {
            subset(list, set);
            return;
        }
        
       for (int i = 0; i < sc.length; ++i) {
           if (v[i] || (i > 0 && sc[i] == sc[i - 1] && !v[i - 1])) {
               continue;
           }
           v[i] = true;
           list.add(sc[i]);
           dfs(sc, v, set, list);
           list.remove(list.size() - 1);
           v[i] = false;
       }
    }
    
    private void subset(List<Character> list, Set<String> set) {
        dfs2(0, list, set, new StringBuilder());
    }
    
    private void dfs2(int index, List<Character> list, Set<String> set, StringBuilder sb) {
        if (sb.length() > 0) {
            set.add(sb.toString());
        }
        
        for (int i = index; i < list.size(); ++i) {
            if (i > index && list.get(i) == list.get(i - 1)) {
                continue;
            }
            
            sb.append(list.get(i));
            dfs2(i + 1, list, set, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

