class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backTracking(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(char[][] board, String word, int m, int n, int wordIdx) {
        if (wordIdx == word.length()) {
            return true;
        }

        char c = word.charAt(wordIdx);

        // System.out.println("word index : " + wordIdx);
        // System.out.println("m : " + m);
        // System.out.println("n : " + n);
        // System.out.println("==========");

        if (c == '#' || m < 0 || m >= board.length || n < 0 || n >= board[0].length || board[m][n] != c) {
            return false;
        }

        board[m][n] = '#';
        boolean found = backTracking(board, word, m + 1, n, wordIdx + 1) || backTracking(board, word, m - 1, n, wordIdx + 1) || backTracking(board, word, m, n + 1, wordIdx + 1) || backTracking(board, word, m, n - 1, wordIdx + 1);
        board[m][n] = c;

        return found;
    }
}