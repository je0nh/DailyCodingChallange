class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        // System.out.println(set.toString());

        int ans = 1;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int seq = 1;

                while (set.contains(n + seq)) {
                    seq++;
                }

                ans = ans < seq ? seq : ans;
            }
        }
        return ans;
    }
}