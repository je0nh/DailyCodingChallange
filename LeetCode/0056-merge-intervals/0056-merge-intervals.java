class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> tmpArr = new ArrayList<>();

        for (int i = 0; i < intervals.length;) {
            int[] tmp = new int[2];
            tmp[0] = intervals[i][0];
            tmp[1] = intervals[i][1];

            int seq = 1;
            while (i + seq < intervals.length && tmp[1] >= intervals[i + seq][0]) {
                if (tmp[1] < intervals[i + seq][1]) {
                    tmp[1] = intervals[i + seq][1];
                }
                seq++;
            }

            // System.out.println(tmp[0] + ", " + tmp[1]);
            // System.out.println(i);
            tmpArr.add(tmp);
            i += seq;
        }

        int[][] answer = new int[tmpArr.size()][2];
        for (int i = 0; i < tmpArr.size(); i++) {
            answer[i] = tmpArr.get(i);
        }
        // System.out.println(answer.toString());
        return answer;
    }
}