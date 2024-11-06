class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 1) return 1;

        Arrays.sort(nums);
        int ans = 0;
        
        int seq = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                seq++;
            } else if (nums[i + 1] > nums[i] + 1) {
                seq = 1;
            }
            ans = ans < seq? seq : ans;
        }

        return ans;
    }
}