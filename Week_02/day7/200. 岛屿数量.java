class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int landNum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfsLands(grid, i, j, visited);
                    landNum++;
                }
            }
        }
        return landNum;
    }

    int[] offsetX = new int[]{0, 0, -1, 1};
    int[] offsetY = new int[]{1, -1, 0, 0};

    private void dfsLands(char[][] grid, int x, int y, boolean[][] visited) {

        for (int i = 0; i < 4; i++) {
            int nX = x + offsetX[i];
            int nY = y + offsetY[i];
            if (nX >= 0 && nX < grid.length && nY >= 0 && nY < grid[0].length && !visited[nX][nY] && grid[nX][nY] == '1') {
                visited[nX][nY] = true;
                dfsLands(grid, nX, nY, visited);
            }
        }

    }
}