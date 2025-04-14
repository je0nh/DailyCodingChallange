class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        q.add(0);
        visited[0] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int s = 0; s < size; s++){
                int idx = q.poll();
                int jump = nums[idx];

                for (int i = 1; i <= jump; i++) {
                    int nextIdx = idx + i;
                    if (nextIdx >= nums.length - 1) return count;

                    if (!visited[nextIdx]) {
                        q.add(nextIdx);
                        visited[nextIdx] = true;
                    }
                }
            }
        }
        return count;
    }
}