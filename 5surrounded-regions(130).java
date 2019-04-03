class Solution {
    // BFS:
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;
    private Queue<int[]> queue;

    // get all O on the edge first
    public void solve2(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        m = board.length; n = board[0].length;
        queue = new LinkedList<>();
        
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') queue.offer(new int[]{0, j});
            if(board[m-1][j] == 'O') queue.offer(new int[]{m-1, j});
        }
        
        for(int i = 1; i < m-1; i++) {
            if(board[i][0] == 'O') queue.offer(new int[]{i, 0});
            if(board[i][n-1] == 'O') queue.offer(new int[]{i, n-1});
        }
        
        bfs(board);
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void bfs(char[][] board) {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            board[i][j] = '#';
            for(int[] d : dirs) {
                int newI = i+d[0], newJ = j+d[1];
                if(newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
                if(board[newI][newJ] == 'O') {
                    board[newI][newJ] = '#';
                    queue.offer(new int[]{newI, newJ});
                }
            }   
        }
    }
}


// DFS:
class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        m = board.length; n = board[0].length;
        
        
        for(int j = 0; j <= n-1; j++) {
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[m-1][j] == 'O') dfs(board, m-1, j);
        }
        
        for(int i = 1; i <= m-2; i++) {
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][n-1] == 'O') dfs(board, i, n-1);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        // invalid
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        // if valid, mark as visited, explore
        if(board[i][j] == 'O') {
            board[i][j] = '#';
            for(int[] d : dirs) {
                int newI = i+d[0], newJ = j+d[1];
                dfs(board, newI, newJ);
            }
        }
    }
}