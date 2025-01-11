class Solution {
    public int snakesAndLadders(int[][] board) {
        List<Integer> convert = boardHelper(board);
        // System.out.println(convert.toString());
        int idx = convert.size();

        boolean[] visited = new boolean[convert.size()];
        Queue<int[]> q = new LinkedList<>();
        // int[] -> {현재 위치, 던진 횟수}
        q.add(new int[]{0, 0});
        visited[0] = true;

        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int current = tmp[0];
            int roll = tmp[1];

            for (int dice = 1; dice <= 6; dice++) {
                int nextIdx = current + dice;

                if (nextIdx >= idx) break;

                int destination = (convert.get(nextIdx) == -1) ? nextIdx : convert.get(nextIdx) - 1;

                if (destination == idx - 1) {
                    return roll + 1;
                }

                if (!visited[destination]) {
                    visited[destination] = true;
                    q.add(new int[]{destination, roll + 1});
                }
            }
        }
        return -1;
    }

    private List<Integer> boardHelper(int[][] ori) {
        int n = ori.length;
        List<Integer> board = new ArrayList<>();
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            int[] line = ori[i];
            if (count % 2 == 0) {
                for (int j = 0; j < line.length; j++) board.add(line[j]);
            } else {
                for (int j = line.length - 1; j >= 0; j--) board.add(line[j]);
            }
            count++;
        }
        return board;
    }
}