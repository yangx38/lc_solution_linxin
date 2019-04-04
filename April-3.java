class Solution {
    // set and map to store the pattern when we visit the map
    Map<Character, String> map;
    //Set<String> set;
    
    public boolean wordPatternMatch(String pattern, String str) {
        // map store the pattern when we visit the map
        map = new HashMap<>();
        //set = new HashSet<>();
        // isMatch(pattern, 0, str, 0)
        return isMatch(pattern, 0, str, 0);
    }

    private boolean isMatch(String pattern, int i, String str, int j) {
        // valid case - both pointers reach the end of str and pattern
        if(i == pattern.length() && j == str.length()) return true;
        // invaild case - only one of them reaches
        if(i == pattern.length() || j == str.length()) return false;

        // pull out the pattern related to that char pattern[i]
        char c = pattern.charAt(i);
        // if we find a match
            // invalid - if same char has different pattern
            // otherwise, step further
            //      if match is done, then check next _pair of str and char of pattern_
        if(map.containsKey(c)) {
            String s = map.get(c);
            if(!str.startsWith(s, j)) return false; 
            return isMatch(pattern, i+1, str, j+s.length());
        }

        // if we cannot find pattern in map which means this is new, 
        // we need to find the end - using for loop
        // each time add one more char & using map and set to see whether seen before
        for (int k = j; k < str.length(); k++) {
            String sub = str.substring(j, k+1);
            //if(set.contains(sub)) continue;
            if(map.containsKey(sub)) continue;
            map.put(c, sub);
           // set.add(sub);
            // now i 即pointer 指到_k+1_的位置
            if(isMatch(pattern, i+1, str, k+1)) return true;
            map.remove(c);
            //set.remove(sub);
        }
        return false;
    }
}


            
            



































// class Solution {
//     // subSum = curSum - prefixSum 
//     public int maxSubArray(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;
//         int curSum = 0, prefixSum = 0;
//         int subSum = Integer.MIN_VALUE;
//         for(int i = 0; i < nums.length; i++) {
//             curSum += nums[i];
//             subSum = Math.max(curSum-prefixSum, subSum);
//             prefixSum = Math.min(curSum, prefixSum);
//         }
//         return subSum;
//     }
// }

// class Solution {
//     public int pivotIndex(int[] nums) {
//         int sum = 0, leftSum = 0;
//         for(int num : nums) sum += num;

//         for(int i = 0; i < nums.length; i++) {
//             if(i != 0) leftSum += nums[i-1];
//             if (leftSum == sum - leftSum - nums[i]) return i;
//         }
//         return -1;
//     }
// }

// class Solution {
//     // BFS:
//     private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//     private int m, n;
//     private Queue<int[]> queue;

//     // get all O on the edge first
//     public void solve2(char[][] board) {
//         if(board == null || board.length == 0 || board[0].length == 0) return;
//         m = board.length; n = board[0].length;
//         queue = new LinkedList<>();
        
//         for(int j = 0; j < n; j++) {
//             if(board[0][j] == 'O') queue.offer(new int[]{0, j});
//             if(board[m-1][j] == 'O') queue.offer(new int[]{m-1, j});
//         }
        
//         for(int i = 1; i < m-1; i++) {
//             if(board[i][0] == 'O') queue.offer(new int[]{i, 0});
//             if(board[i][n-1] == 'O') queue.offer(new int[]{i, n-1});
//         }
        
//         bfs(board);
        
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(board[i][j] == 'O') board[i][j] = 'X';
//                 else if(board[i][j] == '#') board[i][j] = 'O';
//             }
//         }
//     }

//     private void bfs(char[][] board) {
//         while(!queue.isEmpty()) {
//             int[] cur = queue.poll();
//             int i = cur[0], j = cur[1];
//             board[i][j] = '#';
//             for(int[] d : dirs) {
//                 int newI = i+d[0], newJ = j+d[1];
//                 if(newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
//                 if(board[newI][newJ] == 'O') {
//                     board[newI][newJ] = '#';
//                     queue.offer(new int[]{newI, newJ});
//                 }
//             }   
//         }
//     }
// }


// // DFS:
// class Solution {
//     private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//     private int m, n;

//     public void solve(char[][] board) {
//         if(board == null || board.length == 0 || board[0].length == 0) return;
//         m = board.length; n = board[0].length;
        
        
//         for(int j = 0; j <= n-1; j++) {
//             if(board[0][j] == 'O') dfs(board, 0, j);
//             if(board[m-1][j] == 'O') dfs(board, m-1, j);
//         }
        
//         for(int i = 1; i <= m-2; i++) {
//             if(board[i][0] == 'O') dfs(board, i, 0);
//             if(board[i][n-1] == 'O') dfs(board, i, n-1);
//         }
        
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(board[i][j] == 'O') board[i][j] = 'X';
//                 else if(board[i][j] == '#') board[i][j] = 'O';
//             }
//         }
//     }

//     private void dfs(char[][] board, int i, int j) {
//         // invalid
//         if(i < 0 || i >= m || j < 0 || j >= n) return;
//         // if valid, mark as visited, explore
//         if(board[i][j] == 'O') {
//             board[i][j] = '#';
//             for(int[] d : dirs) {
//                 int newI = i+d[0], newJ = j+d[1];
//                 dfs(board, newI, newJ);
//             }
//         }
//     }
// }

// class Solution {
//     private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//     private int m, n;

//     public List<int[]> pacificAtlantic(int[][] matrix) {
//         List<int[]> res = new ArrayList<>();
//         if(matrix.length == 0 || matrix[0].length == 0) return res;
//         m = matrix.length; n = matrix[0].length;

//         boolean[][] checkP = new boolean[m][n];
//         boolean[][] checkA = new boolean[m][n];

//         for (int i = 0; i < m; i++) {
//             helper(matrix, checkP, i, 0); // L
//             helper(matrix, checkA, i, n - 1); //R
//         }
//         for (int i = 0; i < n; i++) { 
//             helper(matrix, checkP, 0, i); // U
//             helper(matrix, checkA, m - 1, i); // D
//         }

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (checkP[i][j] && checkA[i][j]) {
//                     res.add(new int[]{i, j});
//                 }
//             }
//         }

//         return res;
//     }

//     public void helper(int[][] matrix, boolean[][] visited, int i, int j) {
//         visited[i][j] = true;
//         for (int[] d : dirs) {
//             int newI = i + d[0], newJ = j + d[1];
//             if(newI < 0 || newI >= m || newJ < 0 || newJ >=n) continue;
//             if(visited[newI][newJ] || matrix[i][j] > matrix[newI][newJ]) continue;
//             helper(matrix, visited, newI, newJ);
//         }
//     }
// }


// class Solution {
//     private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//     private int[][] visited;
//     private int m, n;

//     public int longestIncreasingPath(int[][] matrix) {
//         if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
//         m = matrix.length; n = matrix[0].length;
//         visited = new int[m][n];
//         int res = 1;
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 int subres = dfs(matrix, i, j);
//                 res = Math.max(res, subres);
//             }
//         }
//         return res;
//     }

//     private int dfs(int[][] matrix, int i, int j) {
//         if(visited[i][j] != 0) return visited[i][j];
//         int max = 1; // max distance from this poiint
//         for(int[] d: dirs) {
//             int newI = i+d[0], newJ = j+d[1];
//             if(newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
//             if(matrix[newI][newJ] <= matrix[i][j]) continue;
//             int len = 1+dfs(matrix, newI, newJ); // len from this direction
//             max = Math.max(max, len);
//         }
//         // write max increasing path value starting from current point in visited matrix
//         visited[i][j] = max; 
//         return max;
//     }
// }


// class Solution {
//     public String reorganizeString(String S) {
//         if(S == null || S.length() == 0) return "";
//         Map<Character, Integer> map = new HashMap<>();
//         for(char c : S.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        
//         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
//         pq.addAll(map.entrySet());
        
//         StringBuilder sb = new StringBuilder();
//         while(!pq.isEmpty()) {
//             Map.Entry<Character, Integer> temp = pq.poll();
            
//             if(sb.length() == 0 || temp.getKey() != sb.charAt(sb.length()-1)) {
//                 sb.append(temp.getKey());
//                 temp.setValue(temp.getValue()-1);
//                 if(temp.getValue() != 0) pq.offer(temp);
//             }
//             else {
//                 Map.Entry<Character, Integer> temp2 = pq.poll();
//                 if(temp2 == null) return "";
//                 sb.append(temp2.getKey());
//                 temp2.setValue(temp2.getValue()-1);
//                 if(temp2.getValue() != 0) pq.offer(temp2);
//                 pq.offer(temp);
                
//             }
//         }
//         return sb.toString();
//     }
// }


// class Solution {
//     public String rearrangeString(String s, int k) {
//         if(s == null || s.length() == 0) return "";
//         Map<Character, Integer> map = new HashMap<>();
//         for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
    
//         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue());
//         pq.addAll(map.entrySet());
    
//         StringBuilder sb = new StringBuilder();
//         // tempQueue 控制是否进行k次循环
//         Queue<Map.Entry<Character, Integer>> tempQueue = new LinkedList<>();
//         while(!pq.isEmpty()) {
//             Map.Entry<Character, Integer> temp = pq.poll();
    
//             sb.append(temp.getKey());
//             temp.setValue(temp.getValue()-1);
//             tempQueue.offer(temp);
    
//             if(tempQueue.size() < k) continue;
//             Map.Entry<Character, Integer> front = tempQueue.poll();
//             if(front.getValue() > 0) pq.offer(front);
//         }
//         return sb.length() == s.length() ? sb.toString() : "";
//     }
// }




// class Solution {
//     public int leastInterval(char[] tasks, int n) {
//         if (tasks == null || tasks.length == 0) return 0;
//         Map<Character, Integer> map = new HashMap<>();
//         for(char c : tasks) map.put(c, map.getOrDefault(c, 0)+1);
    
//         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
//         pq.addAll(map.entrySet());
    
//         int res = 0;
//         while (!pq.isEmpty()) {
//             int interval = n+1;
//             Queue<Map.Entry<Character, Integer>> tempQueue = new LinkedList<>();
    
//             while (interval > 0 && !pq.isEmpty()) {
//                 Map.Entry<Character, Integer> temp = pq.poll();
//                 temp.setValue(temp.getValue()-1);
//                 if(temp.getValue() > 0) tempQueue.offer(temp); // don't want task that already finished
//                 interval--;
//                 res++;
//             }
//             pq.addAll(tempQueue);
//             if (pq.isEmpty()) break; // job done
//             res += interval; //剩下的interval - means idle
//         }
    
//         return res;
//     }
// }




// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         // corner case:
//         char[] sc = s.toCharArray();
//         char[] tc = t.toCharArray();
//         if(sc.length != tc.length) return false;

//         // map is for pc, map2 is for sc
//         int[] map = new int[256];  
//         int[] map2 = new int[256]; 

//         for(int i = 0; i < sc.length; i++) {
//             // tc to sc 走一遍 put in map
//             if(map[sc[i]] != 0 && map[sc[i]] != tc[i]) return false;
//             map[sc[i]] = tc[i];
//             // sc to tc 走一遍 put in map2
//             if(map2[tc[i]] != 0 && map2[tc[i]] != sc[i]) return false;
//             map2[tc[i]] = sc[i];
//         }
//         return true;
//     }
// }



// class Solution {
//     int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//     int m, n;
    
//     public int numEnclaves(int[][] A) {
//         if(A == null || A.length == 0 || A[0].length == 0) return 0;
//         m = A.length; n = A[0].length;
        
//         for(int j = 0; j <= n-1; j++) {
//             if(A[0][j] == 1) dfs(A, 0, j);
//             if(A[m-1][j] == 1) dfs(A, m-1, j);
//         }
        
//         for(int i = 1; i <= m-2; i++) {
//             if(A[i][0] == 1) dfs(A, i, 0);
//             if(A[i][n-1] == 1) dfs(A, i, n-1);
//         }
        
//         int res = 0;
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(A[i][j] == 1) res++;
//                 else if(A[i][j] == 3) A[i][j] = 1;
//             }
//         }
//         return res;
//     }
    
//     public void dfs(int[][] A, int i, int j) {
//         if(i < 0 || i >= m || j < 0 || j >= n) return;
//         if(A[i][j] == 1) {
//             A[i][j] = 3;
//             for(int[] d : dirs) {
//                 int newI = i+d[0], newJ = j+d[1];
//                 dfs(A, newI, newJ);
//             }
//         }
//     }
// }




// class Solution {
//     public boolean wordPattern(String pattern, String str) {
//         // corner case:
//         char[] pc = pattern.toCharArray();
//         String[] sc = str.split("\\s+");
//         if(sc.length != pc.length) return false;


//         // map is for pc, map2 is for sc
//         Map<Character, String> map = new HashMap<>();
//         Map<String, Character> map2 = new HashMap<>();

//         for(int i = 0; i < pc.length; i++) {
//             // pc to sc 走一遍 put in map
//             if(map.containsKey(pc[i]) && !map.get(pc[i]).equals(sc[i])) return false;
//             map.put(pc[i], sc[i]);
//             // sc to pc 走一遍 put in map2
//             if(map2.containsKey(sc[i]) && !map2.get(sc[i]).equals(pc[i])) return false;
//             map2.put(sc[i], pc[i]);
//         }
//         return true;
//     }
// }




// // so if board[i][j] match the char in triNode tree, then we continue, otherwise not
// // bruth force is O(mn 4^k)
// // 注意这道题 用 String word = null 标志结束 instead of using isEnd

// // T = O(m * n * TrieNode)
// // S = TrieNode
// class Solution {
//     // 1. TrieNode class
//     class TrieNode {
//         Map<Character, TrieNode> children;
//         String word;
        
//         public TrieNode() {
//             children = new HashMap<>();
//             word = null;
//         }
//     }

//     // 2. Build Trie
//     public TrieNode buildTrie(String[] words) {
//         TrieNode root = new TrieNode();
//         for(String word : words) {
//             insert(root, word);
//         }
//         return root;
//     }
//     private void insert(TrieNode root, String word) {
//         TrieNode cur = root;
//         for(int i = 0; i < word.length(); i++) {
//             char c = word.charAt(i);
//             TrieNode node = cur.children.get(c);
//             if(node == null) {
//                 node = new TrieNode();
//                 cur.children.put(c, node);
//             }
//             cur = node;
//         }
//         cur.word = word;
//     }

//     // 3. buildTrie based on words, and do DFS search
//     private int m, n;
//     private List<String> res = new ArrayList<>();
//     public List<String> findWords(char[][] board, String[] words) {
//         TrieNode root = buildTrie(words);
//         m = board.length; n = board[0].length;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 helper(board, root, i, j);
//             }
//         }
//         return res;
//     }

//     // 4. DFS helper
//     public void helper(char[][] board, TrieNode cur, int i, int j) {
//         // valid case
//          if (cur.word != null) {
//             res.add(cur.word);
//             cur.word = null;
//         }
//         // invalid case1
//         if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
//         // invalid case2
//         char c = board[i][j];
//         if (c == '#' || cur.children.get(c) == null) return;
//         cur = cur.children.get(c);
       
//         board[i][j] = '#';
//         helper(board, cur, i-1, j);
//         helper(board, cur, i+1, j);
//         helper(board, cur, i, j-1);
//         helper(board, cur, i, j+1);
//         board[i][j] = c;
//     }
// }