class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        int[] ans = new int[2];
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }
        return ans;
    }
}