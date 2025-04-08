class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > 2) {
                continue;
            }
            nums[idx++] = n;
        }
        // System.out.println(idx + 1);
        return idx;
    }
}