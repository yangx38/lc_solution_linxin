class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    
    public int numEnclaves(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0) return 0;
        m = A.length; n = A[0].length;
        
        for(int j = 0; j <= n-1; j++) {
            if(A[0][j] == 1) dfs(A, 0, j);
            if(A[m-1][j] == 1) dfs(A, m-1, j);
        }
        
        for(int i = 1; i <= m-2; i++) {
            if(A[i][0] == 1) dfs(A, i, 0);
            if(A[i][n-1] == 1) dfs(A, i, n-1);
        }
        
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1) res++;
                else if(A[i][j] == 3) A[i][j] = 1;
            }
        }
        return res;
    }
    
    public void dfs(int[][] A, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        if(A[i][j] == 1) {
            A[i][j] = 3;
            for(int[] d : dirs) {
                int newI = i+d[0], newJ = j+d[1];
                dfs(A, newI, newJ);
            }
        }
    }
}