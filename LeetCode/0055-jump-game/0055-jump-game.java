class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int idx = q.poll();
            int jump = nums[idx];

            for (int i = 1; i <= jump; i++) {
                int nextIdx = idx + i;
                if (nextIdx >= nums.length - 1) return true;

                if (!visited[nextIdx]) {
                    q.add(nextIdx);
                    visited[nextIdx] = true;
                }
            }
        }
        return nums.length == 1;
    }
}