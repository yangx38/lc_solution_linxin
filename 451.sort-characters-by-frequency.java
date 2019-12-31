/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (57.27%)
 * Likes:    837
 * Dislikes: 75
 * Total Accepted:    108.7K
 * Total Submissions: 189.7K
 * Testcase Example:  '"tree"'
 *
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input:
 * "tree"
 * 
 * Output:
 * "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * "cccaaa"
 * 
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * "Aabb"
 * 
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * 
 */
class Solution {
    public String frequencySort(String s) {
        int[] cnt = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i)]++;
        }

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < 128; ++i) {
            if (cnt[i] > 0) {
                pairs.add(new Pair((char)i, cnt[i]));
            }
        }
        Collections.sort(pairs, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.cnt != p2.cnt) {
                    return p1.cnt < p2.cnt ? 1: -1;
                }
                return p1.c < p2.c ? -1: 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        int n = pairs.size();
        for (int i = 0; i < n; ++i) {
            Pair p = pairs.get(i);
            while (p.cnt-- > 0) {
                sb.append(p.c);
            }
        }
        return sb.toString();
    }
}

class Pair{
    char c;
    int cnt;
    Pair (char c, int cnt) {
        this.c = c;
        this.cnt = cnt;
    }
}

