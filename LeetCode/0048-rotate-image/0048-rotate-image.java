class Solution {
    public void rotate(int[][] matrix) {
        int maxN = matrix.length;
        int minN = 0;
        
        int count = 0;
        for (int i = maxN - 1; i > 0; i -= 2) {
            count += i * 3;
        }

        System.out.println(count);

        int idx = 0;
        while (idx < count) {
            for (int i = minN; i < maxN - 1 && idx < count; i++) {
                int temp = matrix[minN][i];
                matrix[minN][i] = matrix[i][maxN - 1];
                matrix[i][maxN - 1] = temp;
                idx++;
            }

            int a = 0;
            for (int i = minN; i < maxN - 1 && idx < count; i++) {
                int temp = matrix[minN][i];
                matrix[minN][i] = matrix[maxN - 1][maxN - 1 - a];
                matrix[maxN - 1][maxN - 1 - a] = temp;
                a++;
                idx++;
            }

            int b = 0;
            for (int i = minN; i < maxN - 1 && idx < count; i++) {
                int temp = matrix[minN][i];
                matrix[minN][i] = matrix[maxN - 1 - b][minN];
                matrix[maxN - 1 - b][minN] = temp;
                b++;
                idx++;
            }
            
            minN++;
            maxN--;
        }
    }
}