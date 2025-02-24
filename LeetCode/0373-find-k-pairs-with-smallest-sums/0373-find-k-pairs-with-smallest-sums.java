class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<int[]> q = new PriorityQueue<>((prev, next) -> prev[0] - next[0]);
        Set<String> visited = new HashSet<>();
        
        int[] tmp = new int[3];
        tmp[0] = nums1[0] + nums2[0];
        tmp[1] = 0;
        tmp[2] = 0;
        q.add(tmp);

        visited.add("0,0");
        while (!q.isEmpty() && ans.size() < k) {
            int[] t = q.poll();
            int i = t[1], j = t[2];
            // System.out.printf("[%d, %d]", nums1[i], nums2[j]);

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length && !visited.contains((i + 1) + "," + j)) {
                q.add(new int[] {nums1[i + 1] + nums2[j], i + 1, j});
                visited.add((i + 1) + "," + j);
            }

            if (j + 1 < nums2.length && !visited.contains(i + "," + (j + 1))) {
                q.add(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(i + "," + (j + 1));
            }
        }

        return ans;
    }
}