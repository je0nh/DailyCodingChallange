class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int n : nums) {
            // XOR 연산 : ones ^ 0 -> ones, ones ^ ones -> 0 
            ones = (ones ^ n) & ~twos;
            twos = (twos ^ n) & ~ones;
        }
        return ones;
    }
}