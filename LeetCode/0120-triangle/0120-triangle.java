class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                // System.out.println(triangle.get(i).get(j) + min);
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
            // System.out.println("=============");
        }
        return triangle.get(0).get(0);
    }
}