class Solution {
    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }

    private double binaryExp(double x, long n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= x;
            }

            x *= x;
            n /= 2;
        }

        return ans;
    }
}