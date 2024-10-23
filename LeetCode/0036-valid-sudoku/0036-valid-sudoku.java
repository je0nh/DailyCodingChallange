class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] square = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {continue;}
                
                if (row[i][c - 49] == 1 || col[j][c - 49] == 1 || square[((i / 3) + (j / 3)) + (i / 3) * 2][c - 49] == 1) {return false;}

                row[i][c - 49] = 1;
                col[j][c - 49] = 1;
                square[((i / 3) + (j / 3)) + (i / 3) * 2][c - 49] = 1;
            }
        }

        // System.out.println(Arrays.deepToString(row));
        // System.out.println(Arrays.deepToString(col));
        return true;
    }
}