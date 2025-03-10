class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 2) return points.length;

        int maxCount = 1;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int samePoints = 1;
            int localMax = 0;

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    samePoints++;
                    continue;
                }

                String slope = getSlope(dx, dy);
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeCount.get(slope));
            }

            maxCount = Math.max(maxCount, localMax + samePoints);
        }

        return maxCount;
    }

    private String getSlope(int dx, int dy) {
        if (dx == 0) return "INF";
        if (dy == 0) return "0";

        int gcd = gcd(dx, dy);
        return (dx / gcd) + "/" + (dy / gcd);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}