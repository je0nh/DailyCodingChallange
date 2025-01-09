class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            this.createGraph(prerequisites[i]);
        }

        // 0: 방문안함, 1: 방문중, 2: 방문완료
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!complete(i, visited)) return false;
        }
        return true;
    }

    private void createGraph(int[] prerequisite) {
        int prev = prerequisite[1];
        int next = prerequisite[0];

        graph.putIfAbsent(prev, new ArrayList<>());

        graph.get(prev).add(next);
    }

    private boolean complete(int course, int[] visited) {
        if (visited[course] == 2) return true;

        if (visited[course] == 1) return false;

        visited[course] = 1;

        List<Integer> nextCourses = graph.get(course);
        if (nextCourses != null) {
            for (int next : nextCourses) {
                if (!complete(next, visited)) return false;
            }
        }
        
        visited[course] = 2;
        return true;
    }
}