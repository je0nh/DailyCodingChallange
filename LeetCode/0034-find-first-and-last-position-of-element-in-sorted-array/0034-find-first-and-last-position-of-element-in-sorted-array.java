class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstScanner(nums, target);
        ans[1] = lastScanner(nums, target);
        return ans;
    }

    private int firstScanner(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int first = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return first;
    }

    private int lastScanner(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int last = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return last;
    }
}