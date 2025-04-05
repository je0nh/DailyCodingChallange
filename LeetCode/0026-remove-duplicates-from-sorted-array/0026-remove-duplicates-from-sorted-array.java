class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] < nums[i]) {
                nums[idx++ + 1] = nums[i];
            }
            // System.out.println(Arrays.toString(nums));
        }
        // System.out.println(Arrays.toString(nums));
        // System.out.println(idx + 1);
        return idx + 1;
    }
}