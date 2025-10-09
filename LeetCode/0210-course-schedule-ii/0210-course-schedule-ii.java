class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];

            graph.get(pre).add(course);
            inDegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            ans[idx++] = current;

            for (int next : graph.get(current)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        
        if (idx == numCourses) {
            return ans;
        } else {
            return new int[0];
        }
    }
}
