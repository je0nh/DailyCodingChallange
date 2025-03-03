class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        // 루트는 자기자신을 곱했을 때 원래수가 되는 값
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > x / mid) { // mid * mid > x 랑 같음 -> mid * mid 했을 때 stack overflow 발생
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}