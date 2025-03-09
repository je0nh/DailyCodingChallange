class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        // 이전 집까지 최대 금액
        int dp0 = nums[0];
        // 현재 집까지의 최대 금액
        int dp1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = dp1;
            dp1 = Math.max(dp1, dp0 + nums[i]);
            dp0 = tmp;
        }
        return dp1;
    }
}