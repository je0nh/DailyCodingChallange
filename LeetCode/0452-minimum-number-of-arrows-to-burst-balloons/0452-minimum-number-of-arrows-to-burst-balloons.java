class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 1;

        // for (int[] a : points) System.out.println(Arrays.toString(a));

        int[] temp = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > temp[1]) {
                temp = points[i];
                answer++;
            }
        }
        return answer;
    }
}