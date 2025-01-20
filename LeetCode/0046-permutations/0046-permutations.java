/**
 * |1-1| tmp = [1], visited = [T, F, F]
 * |2-2| tmp = [1, 2], visited = [T, T, F]
 * |3-3| tmp = [1, 2, 3], visited = [T, T, T] -> 끝에 하나씩 지움 tmp = [1, 2], visited = [T, T]
 * |2-2| 끝에 하나씩 지움 tmp = [1], visited = [T, F, F]
 * |2-3| tmp = [1, 3], visited = [T, F, T]
 * |3-2| tmp = [1, 3, 2], visited = [T, T, T]
 */
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {    
        boolean[] visited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, tmp, visited);
        return ans;
    }

    public void dfs(int[] nums, List<Integer> tmp, boolean[] visited) {
        if (tmp.size() == nums.length) {
            List<Integer> copy = new ArrayList<>(tmp);
            ans.add(copy);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            tmp.add(nums[i]);

            dfs(nums, tmp, visited);

            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}