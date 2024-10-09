class Solution {
    public int removeElement(int[] nums, int val) {
        int[] answer = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                answer[count++] = nums[i];
            }
        }
        
        for (int i = 0; i < count; i++) {
            nums[i] = answer[i];
        }

        return count;
    }
}