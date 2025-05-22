class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix[0].length;
        int col = matrix.length;
        int w = 0;
        int h = 0;

        int idx = 0;
        int maxIdx = row * col;
        List<Integer> ans = new ArrayList<>();
        while (idx < maxIdx) {
            // 상
            for (int r = w; r < row && idx < maxIdx; r++) {
                int n = matrix[w][r];
                ans.add(n);
                idx++;
            }

            // 우
            for (int c = h + 1; c < col && idx < maxIdx; c++) {
                int n = matrix[c][row - 1];
                ans.add(n);
                idx++;
            }

            // 하
            for (int r = row - 2; r >= w && idx < maxIdx; r--) {
                int n = matrix[col - 1][r];
                ans.add(n);
                idx++;
            }

            // 좌
            for (int c = col - 2; c > h && idx < maxIdx; c--) {
                int n = matrix[c][w];
                ans.add(n);
                idx++;
            }

            w++;
            h++;
            row--;
            col--;
        }
        return ans;
    }
}