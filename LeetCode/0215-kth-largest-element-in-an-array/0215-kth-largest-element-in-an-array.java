class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (max <= n) {
                max = n;
            }

            if (min > n) {
                min = n;
            }
        }
        // System.out.printf("max: %d, min: %d\n", max, min);

        int[] n = new int[max - min + 1];
        for (int i : nums) {
            n[i - min]++;
        }

        for (int i = n.length - 1; i >= 0; i--) {
            k -= n[i];
            if (k <= 0) {
                return i + min;
            }
        }
        return 0;
    }
}