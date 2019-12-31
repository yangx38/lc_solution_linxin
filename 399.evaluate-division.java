/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 *
 * https://leetcode.com/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (48.71%)
 * Likes:    1537
 * Dislikes: 121
 * Total Accepted:    93.4K
 * Total Submissions: 191.7K
 * Testcase Example:  '[["a","b"],["b","c"]]\n' +
  '[2.0,3.0]\n' +
  '[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]'
 *
 * Equations are given in the format A / B = k, where A and B are variables
 * represented as strings, and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return
 * -1.0.
 * 
 * Example:
 * Given  a / b = 2.0, b / c = 3.0.
 * queries are:  a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return  [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * The input is:  vector<pair<string, string>> equations, vector<double>&
 * values, vector<pair<string, string>> queries , where equations.size() ==
 * values.size(), and the values are positive. This represents the equations.
 * Return  vector<double>.
 * 
 * According to the example above:
 * 
 * 
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]
 * ]. 
 * 
 * 
 * 
 * The input is always valid. You may assume that evaluating the queries will
 * result in no division by zero and there is no contradiction.
 * 
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        int i = 0;
        for (List<String> equation: equations) {
            String a = equation.get(0), b = equation.get(1);
            double val = values[i++];
            map.putIfAbsent(a, new HashMap<>());
            map.get(a).put(b, val);
            map.putIfAbsent(b, new HashMap<>());
            map.get(b).put(a, 1.0 / val);
        }

        double[] res = new double[queries.size()];
        int index = 0;
        for (List<String> query: queries) {
            String x = query.get(0), y = query.get(1);
            if (!map.containsKey(x) || !map.containsKey(y)) {
                res[index++] = -1.0;
            }else {
                Set<String> visited = new HashSet<>();
                visited.add(x);
                double p = dfs(x, y, visited, map);
                res[index++] = p;
            }
        }
        return res;
    }

    private double dfs(String x, String y, Set<String> visited, Map<String, Map<String, Double>> map) {
        if (x.equals(y)) {
            return 1.0;
        }

        Map<String, Double> path = map.get(x);
        for (String next: path.keySet()) {
            if (!visited.contains(next)) {
                visited.add(next);
                double p = path.get(next);
                double subP = dfs(next, y, visited, map);
                if (subP != -1.0) {
                    return p * subP;
                }
            }
        }
        return -1.0;
    }
}

