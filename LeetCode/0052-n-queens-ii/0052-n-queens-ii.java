class Solution {
    private int ans = 0;

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        dfs(n, board, 0);
        return ans;
    }

    private void dfs(int n, boolean[][] board, int row) {
        if (row == n) {
            ans++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(n, board, row, col)){
                board[row][col] = true;
                dfs(n, board, row + 1);
                board[row][col] = false;
            }
        }
    }

    // 검사할때 퀸을 둔 지점을 기준으로 왼쪽, 위, 왼쪽 위, 오른쪽 위 만 검사하면 됨
    private boolean isValid(int n, boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == true) return false;
        }

        for (int i = 0; i < col; i++) {
            if (board[row][i] == true) return false;
        }

        for (int i = row - 1, j  = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == true) return false;
        }

        for (int i = row - 1, j  = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == true) return false;
        }

        return true;
    }
}