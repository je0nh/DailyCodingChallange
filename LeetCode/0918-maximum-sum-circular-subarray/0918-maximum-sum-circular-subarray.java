class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxKadane = maxKadane(nums);
        int minKadane = minKadane(nums);

        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        if (totalSum == minKadane) {
            return maxKadane;
        }

        return maxKadane > totalSum - minKadane ? maxKadane : totalSum - minKadane;
    }

    private int maxKadane(int[] nums) {
        int ans = nums[0];
        int tmp = 0;

        for (int n : nums) {
            if (tmp < 0) {
                tmp = 0;
            }

            tmp += n;
            ans = ans > tmp ? ans : tmp;
        }
        return ans;
    }

    private int minKadane(int[] nums) {
        int ans = nums[0];
        int tmp = 0;

        for (int n : nums) {
            if (tmp > 0) {
                tmp = 0;
            }

            tmp += n;
            ans = ans < tmp ? ans : tmp;
        }
        return ans;
    }
}