class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        List<Integer> visited = new ArrayList<>();
        dfs(candidates, target, sum, 0, visited);
        return ans;
    }

    private void dfs(int[] candidates, int target, int sum, int start, List<Integer> visited) {
        if (sum == target) {
            ans.add(new ArrayList<>(visited));
            return;
        }

        if (sum > target) return;

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            visited.add(num);
            dfs(candidates, target, sum + num, i, visited);
            visited.remove(visited.size() - 1);
        }
    }

    private void dfs(int[] candidates, int target, int sum, List<Integer> visited) {
        List<Integer> copy = new ArrayList<>(visited);

        if (sum == target) {
            if (!ans.contains(copy)) {
                ans.add(copy);
            }
            return;
        }

        if (sum > target) return;

        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            if (!copy.isEmpty() && num < copy.get(copy.size() - 1)) continue;

            copy.add(num);
            dfs(candidates, target, sum + num, copy);
            copy.remove(copy.size() - 1);
        }
    }
}