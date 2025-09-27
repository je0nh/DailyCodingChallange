class Solution {
    private Map<String, Set<Pair<String, Double>>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        init(equations, values);

        int size = queries.size();
        double[] ans = new double[size];
        for (int i = 0; i < size; i++) {
            ans[i] = bfs(queries.get(i));
        }
        return ans;
    }

    private void init(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            
            String a = equation.get(0);
            String b = equation.get(1);
            double value = values[i];
            graph.computeIfAbsent(a, k -> new HashSet<>()).add(new Pair<>(b, value));
            graph.computeIfAbsent(b, k -> new HashSet<>()).add(new Pair<>(a, 1 / value));
        }
    }

    private Double bfs(List<String> query) {
        String a = query.get(0);
        String b = query.get(1);

        if (graph.get(a) == null || graph.get(b) == null) return -1.0;

        Set<String> visited = new HashSet<>();
        Queue<Pair<String, Double>> q = new LinkedList<>();
        q.add(new Pair<>(a, 1.0));
        visited.add(a);
        while (!q.isEmpty()) {
            Pair<String, Double> curr = q.poll();
            String node = curr.getKey();
            double value = curr.getValue();

            if (node.equals(b)) {
                return value;
            }

            for (Pair<String, Double> pair : graph.get(node)) {
                String next = pair.getKey();
                double weight = pair.getValue();
                if (!visited.contains(next)) {
                    q.add(new Pair<>(next, value * weight));
                    visited.add(next);
                }
            }
        }
        return -1.0;
    }
}