class Solution {
    public int minPathSum(int[][] grid) {
        int col = grid[0].length - 1;
        int row = grid.length - 1;

        for (int c = 1; c <= col; c++) {
            grid[0][c] = grid[0][c - 1] + grid[0][c];
        }

        for (int r = 1; r <= row; r++) {
            grid[r][0] = grid[r - 1][0] + grid[r][0];
        }

        for (int c = 1; c <= col; c++) {
            for (int r = 1; r <= row; r++) {
                grid[r][c] = grid[r][c] + Math.min(grid[r - 1][c], grid[r][c - 1]);
            }
        }

        return grid[row][col];
    }
}