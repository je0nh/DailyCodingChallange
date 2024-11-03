class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                answer[0] = map.get(need);
                answer[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        
        return answer;
    }
}