class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            // 하나의 숫자만 한번 등장, 나머지는 모두 두번
            ans = ans ^ n;
        }
        return ans;
    }
}