class Solution {
    public int snakesAndLadders(int[][] board) {
        List<Integer> arr = new ArrayList<>();
        int n = board.length;
        boolean leftToRight = true;

        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) arr.add(board[i][j]);
            } else {
                for (int j = n - 1; j >= 0; j--) arr.add(board[i][j]);
            }
            leftToRight = !leftToRight;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int curr = now[0];
            int rolls = now[1];

            if (curr == n * n) return rolls;

            for (int dice = 1; dice <= 6; dice++) {
                int next = curr + dice;
                if (next > n * n) break;

                int move = arr.get(next - 1);
                if (move != -1) next = move;

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, rolls + 1});
                }
            }
        }
        return -1;
    }
}