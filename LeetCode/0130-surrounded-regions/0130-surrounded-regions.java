class Solution {
    private int m, n;
    private char[][] tmp;

    public void solve(char[][] board) {
        m = board[0].length;
        n = board.length;

        tmp = board;
        for (int i = 0; i < n; i++) {
            dfs(i, 0);
            dfs(i, m - 1);
        }

        for (int i = 0; i < m; i++) {
            dfs(0, i);
            dfs(n - 1, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 'O') board[i][j] = 'X';
                if (tmp[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int y, int x) {
        if (x < 0 || x >= m || y < 0 || y >= n || tmp[y][x] == 'A' || tmp[y][x] == 'X') return;

        if (tmp[y][x] == 'O') tmp[y][x] = 'A';

        dfs(y - 1, x);
        dfs(y + 1, x);
        dfs(y, x - 1);
        dfs(y, x + 1);
    }

    /**
    [["X","O","X","O","X","O"],
     ["O","X","O","X","O","X"],
     ["X","O","X","O","X","O"],
     ["O","X","O","X","O","X"]]
     */
}