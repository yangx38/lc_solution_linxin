class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] visited;
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        visited = new int[m][n];
        int res = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int subres = dfs(matrix, i, j);
                res = Math.max(res, subres);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if(visited[i][j] != 0) return visited[i][j];
        int max = 1; // max distance from this poiint
        for(int[] d: dirs) {
            int newI = i+d[0], newJ = j+d[1];
            if(newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
            if(matrix[newI][newJ] <= matrix[i][j]) continue;
            int len = 1+dfs(matrix, newI, newJ); // len from this direction
            max = Math.max(max, len);
        }
        // write max increasing path value starting from current point in visited matrix
        visited[i][j] = max; 
        return max;
    }
}