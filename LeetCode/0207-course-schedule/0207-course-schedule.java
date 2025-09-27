class Solution {
    private boolean[] visited;
    private boolean[] onPath;
    private int[][] graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new int[numCourses][numCourses];
        
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            graph[b][a] = 1;
        }

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (onPath[course]) return true;
        if (visited[course]) return false;

        onPath[course] = true;
        for (int next = 0; next < graph.length; next++) {
            if (graph[course][next] == 1) {
                if (dfs(next)) return true;
            }
        }
        onPath[course] = false;
        visited[course] = true;

        return false;
    }
}
