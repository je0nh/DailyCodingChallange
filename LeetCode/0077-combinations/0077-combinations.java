class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        Queue<List<Integer>> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            q.add(tmp);
        }

        while (!q.isEmpty()) {
            List<Integer> combination = q.poll();
            int num = combination.get(combination.size() - 1);

            if (combination.size() == k) {
                ans.add(combination);
                continue;
            }

            for (int i = num + 1; i <= n; i++) {
                List<Integer> copy = new ArrayList<>(combination);
                copy.add(i);
                q.add(copy);
                // System.out.println(copy);
            }
        }
        return ans;
    }
}