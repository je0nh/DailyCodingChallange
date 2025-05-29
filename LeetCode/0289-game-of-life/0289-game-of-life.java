class Solution {
    private int n;
    private int m;

    public void gameOfLife(int[][] board) {
        this.n = board.length;
        this.m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int b = board[i][j];
                int count = checkCell(board, i, j);

                if (b == 1 && (count < 2 || count > 3)) {
                    board[i][j] = -1;
                } else if(b == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }

    private int checkCell(int[][] board, int r, int c) {
        int count = 0;

        int[][] maps = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] map : maps) {
            int row = r + map[0];
            int col = c + map[1];

            if (row >= 0 && row < n && col < m && col >= 0) {
                if (Math.abs(board[row][col]) == 1) count++;
            }
        }
        return count;
    }
}