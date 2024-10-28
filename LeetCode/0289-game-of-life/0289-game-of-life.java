class Solution {
    public void gameOfLife(int[][] board) {
        int m = board[0].length;
        int n = board.length;

        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int sum = 0;
                int tl = (i > 0 && j > 0) ? board[i - 1][j - 1] : 0;
                int t = (i > 0) ? board[i - 1][j] : 0;
                int tr = (i > 0 && j < m - 1) ? board[i - 1][j + 1] : 0;
                int l = (j > 0) ? board[i][j - 1] : 0;
                int r = (j < m - 1) ? board[i][j + 1] : 0;
                int bl = (i < n - 1 && j > 0) ? board[i + 1][j - 1] : 0;
                int b = (i < n - 1) ? board[i + 1][j] : 0;
                int br = (i < n - 1 && j < m - 1) ? board[i + 1][j + 1] : 0;

                sum += tl + t + tr + l + r + bl + b + br;
                sumList.add(sum);
            }
        }

        // System.out.println(sumList.toString());
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (sumList.get(idx) < 2 || sumList.get(idx) > 3) {
                    board[i][j] = 0;
                } else if (sumList.get(idx) == 3) {
                    board[i][j] = 1;
                }
                idx++;
            }
        }
    }
}