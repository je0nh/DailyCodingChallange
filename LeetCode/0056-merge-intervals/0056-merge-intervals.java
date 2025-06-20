class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (prev, next) -> Integer.compare(prev[0], next[0]));

        List<int[]> tmp = new ArrayList<>();
        int idx = 0;
        while (idx < intervals.length) {
            int[] interval = intervals[idx];
            
            while (idx < intervals.length - 1 && interval[1] >= intervals[idx + 1][0]) {
                // System.out.println(intervals[idx + 1][1]);
                interval[1] = intervals[idx + 1][1] > interval[1] ? intervals[idx + 1][1] : interval[1];
                idx++;
            }

            tmp.add(interval);
            idx++;
        }

        int[][] ans = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            ans[i] = tmp.get(i);
        }
        return ans;
    }
}