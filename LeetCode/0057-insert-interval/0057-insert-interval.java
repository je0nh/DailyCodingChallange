class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tmp = new ArrayList<>();

        if (intervals.length == 0) return new int[][]{newInterval};

        int idx = 0;
        int n = intervals.length;
        while (idx < n && intervals[idx][1] < newInterval[0]) {
            tmp.add(intervals[idx]);
            idx++;
        }

        while (idx < n && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }
        tmp.add(newInterval);

        while (idx < n) {
            tmp.add(intervals[idx]);
            idx++;
        }

        int[][] ans = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            ans[i] = tmp.get(i);
        }
        return ans;
    }
}