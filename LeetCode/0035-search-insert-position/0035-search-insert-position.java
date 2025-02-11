class Solution {
    public int searchInsert(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    private int helper(int[] nums, int first, int last, int target) {
        if (first > last) {
            return first;
        }

        int idx = (first + last) / 2;

        if (target < nums[idx]) {
            return helper(nums, first, idx - 1, target);
        } else if (target > nums[idx]) {
            return helper(nums, idx + 1, last, target);
        } else {
            return idx;
        }
    }
}