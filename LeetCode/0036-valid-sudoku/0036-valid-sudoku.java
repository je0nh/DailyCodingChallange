class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1';
                    if (check[num]) return false;
                    check[num] = true;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            boolean[] check = new boolean[9];
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1';
                    if (check[num]) return false;
                    check[num] = true;
                }
            }
        }

        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                boolean[] check = new boolean[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = board[boxRow * 3 + i][boxCol * 3 + j];
                        if (c != '.') {
                            int num = c - '1';
                            if (check[num]) return false;
                            check[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
