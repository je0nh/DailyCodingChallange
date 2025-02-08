class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int tmp = 0;

        for (int n : nums) {
            if (tmp < 0) {
                tmp = 0;
            }

            tmp += n;
            ans = tmp > ans ? tmp : ans;
        }
        return ans;
    }
}