class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 모든 수를 큐에 넣어줌
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
                // 얕은 복사로 가져오지 않으면 기존 리스트에 계속 더하는 방식으로 큐에 저장이 됨
                // [1, 2, 3] => 깊은 복사로 리스트 복사 시
                // [1, 2] [1, 3] [1, 4] [2, 3] [2, 4] ... 이런식으로 큐에 저장이 되어야함
                List<Integer> copy = new ArrayList<>(combination);
                copy.add(i);
                q.add(copy);
                // System.out.println(copy);
            }
            // 마지막 [4]의 경우 큐에 넣지 않음
        }
        return ans;
    }
}