class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        int seq = 1;
        for (int i = 0; i < nums.length;) {
            int min = nums[i];

            while (i + seq < nums.length && nums[i + seq] == nums[i] + seq) {
                min = nums[i + seq];
                seq++;
            }

            if (nums[i] == min){
                String tmp = String.valueOf(min);
                ans.add(tmp);
            } else {
                String tmp = nums[i] + "->" + min;
                ans.add(tmp);
            }

            i += seq;
            seq = 1;
        }
        return ans;
    }
}