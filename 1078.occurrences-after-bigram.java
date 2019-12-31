/*
 * @lc app=leetcode id=1078 lang=java
 *
 * [1078] Occurrences After Bigram
 *
 * https://leetcode.com/problems/occurrences-after-bigram/description/
 *
 * algorithms
 * Easy (64.81%)
 * Likes:    58
 * Dislikes: 85
 * Total Accepted:    15.5K
 * Total Submissions: 23.9K
 * Testcase Example:  '"alice is a good girl she is a good student"\n"a"\n"good"'
 *
 * Given words first and second, consider occurrences in some text of the form
 * "first second third", where second comes immediately after first, and third
 * comes immediately after second.
 * 
 * For each such occurrence, add "third" to the answer, and return the
 * answer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text = "alice is a good girl she is a good student", first = "a",
 * second = "good"
 * Output: ["girl","student"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= text.length <= 1000
 * text consists of space separated words, where each word consists of
 * lowercase English letters.
 * 1 <= first.length, second.length <= 10
 * first and second consist of lowercase English letters.
 * 
 * 
 * 
 */
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        // Deque<Long> deque = new LinkedList<>();
        // long hashCode = 0;
        // long power = 1;
        // int mod = 1000000007;
        // long targetHash = 0;
        // for (int i = 0; i < first.length(); ++i) {
        //     targetHash = (targetHash * 31 + first.charAt(i)) % mod;
        // }
        // for (int j = 0; j < second.length(); ++j) {
        //     targetHash = (targetHash * 31 + second.charAt(j)) % mod;
        // }

        // String[] words = text.split(" ");
        // List<String> list = new ArrayList<>();
        // for (int i = 0; i < words.length; ++i) {
        //     if (words[i].isEmpty()) continue;
        //     String word = words[i];
        //     int n = words[i].length();
        //     for (int j = 0; j < n; ++j) {
        //         hashCode = (hashCode * 31 + word.charAt(j)) % mod;
        //         power = (power * 31) % mod;
        //         deque.offerLast(power);
        //     }
        //     if (i >= 1) {
        //         if (i >= 2) {
        //             int k = words[i - 2].length();
        //             String x = words[i - 2];
        //             for (int l = 0; l < k; ++l) {
        //                 hashCode = ((hashCode - x.charAt(l) * deque.pollLast()) % mod + mod) % mod;
        //             }
        //         }

        //         if (hashCode == targetHash && words[i - 1].equals(first) && words[i].equals(second)) {
        //             if (i + 1 < words.length) {
        //                 list.add(words[i + 1]);
        //             }
        //         }
        //     }
        // }

        // String[] res = new String[list.size()];
        // int index = 0;
        // for (String s: list) {
        //     res[index++] = s;
        // }
        // return res;
        String[] words = text.split(" ");
        int n = words.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i + 2 < n; ++i) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                list.add(words[i + 2]);
            }
        }
        String[] res = new String[list.size()];
        int index = 0;
        for (String s: list) {
            res[index++] = s;
        }
        return res;
    }
}

