class Solution {
    private int m, n;
    private char[][] tmp;

    public int numIslands(char[][] grid) {
        m = grid[0].length;
        n = grid.length;
        tmp = grid;

        int count = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == '1') count++;

                dfs(i, j);
            }
        }

        return count;
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || tmp[x][y] == '0') return;

        tmp[x][y] = '0';

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }
}