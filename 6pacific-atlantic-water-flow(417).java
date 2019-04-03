class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        m = matrix.length; n = matrix[0].length;

        boolean[][] checkP = new boolean[m][n];
        boolean[][] checkA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            helper(matrix, checkP, i, 0); // L
            helper(matrix, checkA, i, n - 1); //R
        }
        for (int i = 0; i < n; i++) { 
            helper(matrix, checkP, 0, i); // U
            helper(matrix, checkA, m - 1, i); // D
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checkP[i][j] && checkA[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;
    }

    public void helper(int[][] matrix, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        for (int[] d : dirs) {
            int newI = i + d[0], newJ = j + d[1];
            if(newI < 0 || newI >= m || newJ < 0 || newJ >=n) continue;
            if(visited[newI][newJ] || matrix[i][j] > matrix[newI][newJ]) continue;
            helper(matrix, visited, newI, newJ);
        }
    }
}
