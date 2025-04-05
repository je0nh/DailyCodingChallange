class Solution {
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                ans++;
                nums[idx++] = nums[i];
            }
        }
        return ans;
    }
}