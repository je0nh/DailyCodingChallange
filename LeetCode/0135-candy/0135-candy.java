class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = 1;
            if (i > 0 && ratings[i - 1] < ratings[i]) tmp[i] = tmp[i - 1] + 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                tmp[i] = Math.max(tmp[i], tmp[i + 1] + 1);
            }
        }
        
        // System.out.println(Arrays.toString(tmp));
        int ans = 0;
        for (int t : tmp) ans += t;
        return ans;
    }
}