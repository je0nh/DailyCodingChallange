class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int left = 0;
        int right = nums.length - 1;

        int min = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (nums[mid] < min) {
                min = nums[mid];
            }
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { 
                right = mid;
            }
        }
        return min < nums[left] ? min : nums[left];
    }
}