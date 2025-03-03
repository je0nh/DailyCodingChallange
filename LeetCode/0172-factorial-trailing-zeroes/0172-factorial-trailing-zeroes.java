class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            // 5가 추가적으로 있는것을 세기 위해
            n /= 5;
        }
        return count;
    }
}