/**
 * 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
// T = O(mn*4^L) 4^L for each cell b/c of the recursion
// S = O(L) w/ L len of word
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        if(board == null || board.length == 0) return false;
        m = board.length; n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int pos) {
        if(pos == word.length()) return true;
        if(i < 0 || i >= m || j < 0 || j >= n) return false;
        if(board[i][j] != word.charAt(pos)) return false;
        // explore
        boolean res = false;
        for(int[] d : dirs) {
            char c = board[i][j];
            board[i][j] = '#';
            res = dfs(board, word, i+d[0], j+d[1], pos+1);
            if(res) break;
            board[i][j] = c;
       }  
        return res;
    }
}

/**
 * 133. Clone Graph
 * definition for a node - public Node(int _val,List<Node> _neighbors) 
 * implement public Node cloneGraph(Node node)
 */
// 题意:
    // Node(int val, List<Node> neighbors)
    // clone the graph
// 思路: 
    // DFS w/ HashMap recursion
// 步骤 - DFS
    // Map<Node, Node> 避免recopy K - 给的节点, V - 复制的节点
    // helper
        // 已经复制过了 -> return 
        // 复制这个节点 to get Node _copy_, put in map
        // 遍历原node的ne,  add **ne's copy (即helper(ne))** to Node_copy_'s neighbor
        // 返回map里的copy
// T = O(|V|+|E|)
// S = O(|V|)

// - - - - - - - - - - - - - - - - - - - - - - - - - 
// 思路: BFS用queue提炼所有|V|, construct map 
// 步骤: 
    // 提炼V w/ **queue and set**
        // while queue not empty
            // poll -> cur
            // 遍历cur's neighbors
            // if not in set
                // add to queue && set
        // return ArrayList<>(set) -> List<Node>
    // 根据ArrayList建立graph w/ **map** 
        // put original and new Node into map
        // 连接所有E
            // 遍历ArrayList (V的集合)
	        // n as 原Node; copy as 复制品
	        //对于每个n’s neighbors, put the copy of n’s neighbors to dup’s neighbors
// T = O(|V|+|E|)
// S = O(|V|)

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return helper(node);
    }
    
    private Node helper(Node node) {
        if(map.containsKey(node)) return map.get(node);
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);
        for(Node ne : node.neighbors) {
            copy.neighbors.add(helper(ne));
        }
        return map.get(node);
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        List<Node> nodes = bfs(node);
        Map<Node, Node> map = new HashMap<>();
        // V: 
        for(Node n : nodes) {
            map.put(n, new Node(n.val, new ArrayList<>()));
        }
        // E
        for(Node n : nodes) {
            Node dup = map.get(n);
            for(Node ne : n.neighbors) {
                dup.neighbors.add(map.get(ne));
            }
        }
        return map.get(node);
    }
    
    private List<Node> bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(node); set.add(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node ne : cur.neighbors) {
                if(!set.contains(ne)) {
                    set.add(ne);
                    queue.offer(ne);
                }
            }
        }
        return new ArrayList<>(set);
    }
}

/**
 * 138. Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * public Node(int _val,Node _next,Node _random) 
 * 
 * 
 */
// 题意:
    // Node组成: Node(int val, Node noext, Node random) 
    // 给定head, deep copy 整个List
// 思路: 
    // use Map<Node, Node> as org, copy, 遍历两边List, 第一次提取|V|, 第二次
// 步骤: 
    // Map<Node, Node> - org, copy 
    // 遍历第一遍 -> put org, new Node()
    // 遍历第二遍 -> 赋值, 注意用于赋值的_Node_也是copy
// T = O(n) 
// S = O(n)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>(); // org, copy
        Node cur = head;
        // |V|
        while(cur != null) {
            map.put(cur, new Node());
            cur = cur.next;
        }
        
        cur = head;
        while(cur != null) {
            Node clone = map.get(cur);
            clone.val = cur.val;
            clone.next = map.get(cur.next);
            clone.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }   
}

/**
 * 417. Pacific Atlantic Water Flow
 * Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix)
 */
// T = O(m*n)
// S = O(m*n)
// 题意: 
    // return 坐标collection st. can reach both A and P
// 思路: 
    // tricky part - how to mark visited
    // 用两个visited, int[][] checkP && checkA, then go thru both and add to res
// 步骤: 
    // 把 checkP && checkA 嵌入到DFS的parameter中
    // 四周出发DFS
    // checkP && checkA, update res
    // helper - check部分
        // 在看水过不过的去时牵扯新旧坐标对比
            // 所以要validate both 新旧坐标
	    // mark in int[][]check as “can reach“
	    // explore
		    // invalid - 
			// out of bound 
			// checked 
			// 水过不去
		    // helper(newI, newJ)

// T = O(m*n)
// S = O(m*n) - checked
class Solution {
    int m, n;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        m = matrix.length; n = matrix[0].length;
        int[][] checkP = new int[m][n], checkA = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            helper(matrix, checkP, i, 0);
            helper(matrix, checkA, i, n-1);
        }
        
        for(int i = 0; i < n; i++) {
            helper(matrix, checkP, 0, i);
            helper(matrix, checkA, m-1, i);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(checkP[i][j] == 1 && checkA[i][j] == 1) {
                    List<Integer> subres = new ArrayList<>();
                    subres.add(i); subres.add(j);
                    res.add(subres);
                }
            }
        }
        return res;
    }
    
    private void helper(int[][] matrix, int[][] check, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        check[i][j] = 1;
        for(int[] d : dirs) {
            int newI = i+d[0], newJ = j+d[1];
            if(newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
            if(check[newI][newJ] == 1 || matrix[newI][newJ] < matrix[i][j]) continue;
            helper(matrix, check, newI, newJ);
        }
    }
}

/**
 * 934. Shortest Bridge
 * Input: 
 * [[1,1,1,1,1],
 *  [1,0,0,0,1],
 *  [1,0,1,0,1],
 *  [1,0,0,0,1],
 *  [1,1,1,1,1]]
Output: 1
 */
// 题意: 
    // int[][]A contains 2 connected groups, min # to change 0 to 1 to make all 1 connected
// 思路: 
    // DFS to find one island, mark all positions of first island to '1' in visited, add to queue as sources, all positions can be the starting points of BFS
        // 注意: need two "break" statements to jump out two for loops
    // BFS to expand this island till touch the other island
// T = O(mn)
// S = O(mn)
// T = O(mn)
// S = O(mn)
class Solution { 
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m = 0, n = 0;
    int[][] visited = null;
    Queue<int[]> queue = new LinkedList<>();
    
    public int shortestBridge(int[][] A) {
        m = A.length; n = A[0].length;
        visited = new int[m][n];
        
        boolean found = false;
        for(int i = 0; i < m; i++) {
            // MUST use a boolean variable to check if we already marked the first island in visited. Otherwise, we will only break from the inner loop, but will not jump out the outer loop
            if(found) break;
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1) {
                    dfs(A, i, j);
                    found = true;
                    break;
                }
            }
        }

        int step = 0;
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for(int k = 0; k< size; k++) {
                int[] cur = queue.poll();
                for(int[] d : dirs) {
                    int newI = cur[0]+d[0];
                    int newJ = cur[1]+d[1];
                    if(newI < 0 || newJ < 0 || newI >= m || newJ >= n || visited[newI][newJ] == 1) continue;
                    if(A[newI][newJ] == 1) return step-1;
                    visited[newI][newJ] = 1; queue.offer(new int[]{newI, newJ});
                }
            }
        }
        return -1;
    }
    
    
    private void dfs(int[][] A,int i, int j) {
        if(i < 0 || j < 0 || i >= m || j >= n) return;
        if(visited[i][j] == 1 || A[i][j] == 0) return;
        visited[i][j] = 1; queue.offer(new int[]{i, j});
        for(int[] d : dirs) {
            dfs(A, i+d[0], j+d[1]);
        }
    }
}

/**
 * 212. Word Search II
 * Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
 */
// 212. Word Search II
// 题意: 
    // find all words of dict in the board, same cell may not be used more than once in a word
// 思路: 
    // 从words入手, build trie
    // start from every cell
        // valid invalid case
        // update 遍历TrieNode cur, move on
        // change to visited; explore using new TrieNode and newIJ; back to original char in the end
// T = O(mn * TrieNode)
// S = O(TrieNode)
class Solution {
    int m, n;
    List<String> res = new ArrayList<>();
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = buildTrie(words);
        m = board.length; n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(board, trie, i, j);
            }
        }
        return res;
    }
    
    private void helper(char[][] board, TrieNode cur, int i, int j) {
        // valid case
        if(cur.isEnd != null) {
            res.add(cur.isEnd);
            cur.isEnd = null;
        }
        // invalid case
            // 越界, null, have visited
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        
        char c = board[i][j];
        if(c == '#') return;
        if(cur.children.get(c) == null) return;
        cur = cur.children.get(c);
        // explore
        for(int[] d : dirs) {
            board[i][j] = '#';
            helper(board, cur, i+d[0], j+d[1]);
            board[i][j] = c;
        }
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            insert(root, word);
        }
        return root;
    }
    
    private void insert(TrieNode cur, String word) {
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = cur.children.get(c);
            if(node == null) {
                node = new TrieNode();
                cur.children.put(c, node);
            }
            cur = node;
        }
        cur.isEnd = word;
    }
    
    class TrieNode {
        Map<Character, TrieNode> children;
        String isEnd;
        
        public TrieNode() {
            children = new HashMap<>();
            isEnd = null;
        }
    }
}

/**
 * 332. Reconstruct Itinerary
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
But it is larger in lexical order.
 */
// 题意: 
    // 重新排列飞机票, st. 起点是"JFK", return List<String> 给的是directed graph, 保证存在一条路径, 使得从”JFK”出发, 能恰好遍历所有的边一次, 返回此路径
    // 多解取smallest lexi order
// 思路: brute force - backtracking https://www.youtube.com/watch?v=LKSdX31pXjY
    // 建图Map<String, List<String>>, sort each List lexically
    // 从JFK开始尝试全部路径, remove访问过的边,  backtrack恢复, 返回**第一个永远全部ticket的路径**
    // T = O(n)建图 + O(nlogn)sort + O(n!) backtracking
        // 一开始n张票选择, 下一次n-1张票选择, 对以"JFK"开头的路径permutation
    // S = O(n)
// 思路: Eulerian path - **对于directed graph, 遍历所有的边一次** https://www.youtube.com/watch?v=LKSdX31pXjY 10:12
	// 存在条件: 
		// no disconnected part  
		// 每个点入度 == 出度 或者 (一个点入度比出度少1(起点), 一个点出度比入度少1(终点), 其余每个点入度 == 出度)
	// 算法: 
		// path = []
		// DFS(u): 
			// while u存在没访问边(u, v)
                // mark (u, v) as visited
                    // DFS(v):
            // path.pushLeft(u)
	// 因为此题需要lexi order, 用pq
	// T = O(n+nlogn)建图 + O(n) 不会把边unmark visit, 所以每个边mark一次
    // S = O(n)	
    
// T = O(n) + O(nlogn) + O(n!) = O(n!)
// S = O(n)
class Solution {
    Map<String, List<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    int totalLen = 0;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0) return null;
        totalLen = tickets.size()+1;
        for(List<String> ticket : tickets) {
            String u = ticket.get(0), v = ticket.get(1);
            if(!map.containsKey(u)) map.put(u, new ArrayList<>());
            map.get(u).add(v);
        }
        for(List<String> list : map.values()) Collections.sort(list);
        res.add("JFK");
        if(helper("JFK")) return res;
        return null;
    }
    
    private boolean helper(String u) {
        if(res.size() == totalLen) return true;
        if(!map.containsKey(u)) return false;
        List<String> vs = map.get(u);
        for(int i = 0; i < vs.size(); i++) {
            String v = vs.get(i);
            vs.remove(i);
            res.add(v);
            if(helper(v)) return true;
            res.remove(res.size()-1);
            vs.add(i, v);
        }
        return false;
    }
}

// T = O(n+nlogn)建图 + O(n)
// S = O(n)	
class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0) return new ArrayList<>();
        for(List<String> ticket : tickets) {
            String u = ticket.get(0), v = ticket.get(1);
            if(!map.containsKey(u)) map.put(u, new PriorityQueue<>());
            map.get(u).add(v);
        }
        dfs("JFK");
        return res;
    }
    
    private void dfs(String u) {
        while(map.containsKey(u) && !map.get(u).isEmpty()) {
            String v = map.get(u).poll();
            dfs(v);
        }
        res.add(0, u);
    }
}

/**
 * 399. Evaluate Division
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 */
// 题意: 
    // given equations及其对应values, 求queries的值返回, if no answer, return -1.0
    // all values positive
    // 例子: equations = [["a", "b"], ["b", "c"]], values = [2.0, 3.0],
        // queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
        // return [6.0, 0.5, -1.0, 1.0, -1.0]
// 思路: 
    // 建directed graph - a->b weight as val; b->a weight as 1/val
    // DFS 注意用HashSet保证不会重复访问, 即不会死循环; each query as x/y so valid case is when x == y
    // 遍历邻居 - 如果路径存在 返回
// T = |V|+|V|*|n| V as equations.length, n as queries' length, 
// S = |V+n|
class Solution {
    Map<String, List<Node>> map = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if(equations.size() != values.length) return null;
        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String first = equation.get(0), second = equation.get(1); double k = values[i];
            if(!map.containsKey(first)) map.put(first, new ArrayList<>());
            map.get(first).add(new Node(second, k));
            if(!map.containsKey(second)) map.put(second, new ArrayList<>());
            map.get(second).add(new Node(first, 1/k));
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < res.length; i++) {
            List<String> query = queries.get(i);
            String x = query.get(0), y = query.get(1);
            res[i] = dfs(x, y, 1, new HashSet<>());
        }
        return res;
    }
    
    private double dfs(String x, String y, double value, Set<String> visited) {
        if(visited.contains(x)) return -1;
        if(!map.containsKey(x)) return -1;

        if(x.equals(y)) return value;
        visited.add(x);
        for(Node next : map.get(x)) {
            String z = next.den;
            if(visited.contains(z)) continue;
            
            double sub = dfs(z, y, value * next.weight, visited);
            if(sub != -1.0) return sub; 
        }
        visited.remove(x);
        return -1;
    }
    
    class Node {
        String den; // destination
        double weight;
        public Node(String den, double weight) {
            this.den = den;
            this.weight = weight;
        }
    }
}