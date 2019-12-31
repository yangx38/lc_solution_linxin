/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 *
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Medium (32.53%)
 * Likes:    935
 * Dislikes: 614
 * Total Accepted:    95.8K
 * Total Submissions: 293.8K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * Given a list of airline tickets represented by pairs of departure and
 * arrival airports [from, to], reconstruct the itinerary in order. All of the
 * tickets belong to a man who departs from JFK. Thus, the itinerary must begin
 * with JFK.
 * 
 * Note:
 * 
 * 
 * If there are multiple valid itineraries, you should return the itinerary
 * that has the smallest lexical order when read as a single string. For
 * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 * 
 * 
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> id = new HashMap<>();
        int n = 0;
        
        for (List<String> ticket: tickets) {
            String u = ticket.get(0), v = ticket.get(1);
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);
            if (!id.containsKey(u)) {
                id.put(u, n++);
            }
            if (!id.containsKey(v)) {
                id.put(v, n++);
            }
        }
        
       int[][] cnt = new int[n][n];
       for (List<String> ticket: tickets) {
            String from = ticket.get(0), to = ticket.get(1);
           int u = id.get(from), v = id.get(to);
           cnt[u][v]++;
       }
        
        
        for (List<String> list: map.values()) {
            Collections.sort(list);
        }
        
        List<String> res = new ArrayList<>();
        res.add("JFK");
        findPath("JFK", tickets.size() + 1, map, id, cnt, res);
        return res;
    }
    
    private void findPath(String cur, int n, Map<String, List<String>> map, Map<String, Integer> id, int[][] cnt, List<String> res) {
        if (res.size() == n || !map.containsKey(cur)) {
            return;
        }
        
        List<String> nextCities = map.get(cur);
        int u = id.get(cur);
        for (String next: nextCities) {
            int v = id.get(next);
            if (cnt[u][v] > 0) {
                cnt[u][v]--;
                res.add(next);
                findPath(next, n, map, id, cnt, res);
                if (res.size() == n) {
                    return;
                }
                cnt[u][v]++;
                res.remove(res.size() - 1);
            }
        }
    }
}

