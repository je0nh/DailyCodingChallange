class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            createGraph(prerequisite);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            if (!checkCourse(i, visited)) return new int[0];
        }
        
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = result.get(numCourses - 1 - i);
        }
        return ans;
    }

    private void createGraph(int[] prerequisite) {
        Integer prev = prerequisite[1];
        Integer next = prerequisite[0];

        graph.putIfAbsent(prev, new ArrayList<>());

        graph.get(prev).add(next);
    }

    private boolean checkCourse(int course, int[] visited) {
        if (visited[course] == 2) return true;
        if (visited[course] == 1) return false;

        visited[course] = 1;
        List<Integer> nextCourse = graph.get(course);
        if (nextCourse != null) {
            for (Integer next : nextCourse) {
                if (!checkCourse(next, visited)) return false;
            }
        }
        visited[course] = 2;

        result.add(course);
        return true;
    }
}