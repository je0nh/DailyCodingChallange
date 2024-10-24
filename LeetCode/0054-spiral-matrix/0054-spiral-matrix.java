class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int w = 0;
        int h = 0;

        int idx = 0;
        int maxIdx = n * m;
        List<Integer> answer = new ArrayList<>();
        while (idx < maxIdx) {
            for (int p = w; p < n && idx < maxIdx; p++) {
                int a = matrix[h][p];
                answer.add(a);
                idx++;
            }

            for (int p = h + 1; p < m && idx < maxIdx; p++) {
                int a = matrix[p][n - 1];
                answer.add(a);
                idx++;
            }
                        
            for (int p = n - 2; p > w && idx < maxIdx; p--) {
                int a = matrix[m - 1][p];
                answer.add(a);
                idx++;
            }

            for (int p = m - 1; p > h && idx < maxIdx; p--) {
                int a = matrix[p][w];
                answer.add(a);
                idx++;
            }

            w++;
            h++;
            n--;
            m--;
        }

        return answer;
    }
}