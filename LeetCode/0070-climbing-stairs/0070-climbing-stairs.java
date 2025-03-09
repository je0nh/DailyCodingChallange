class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        // 각 계단에 도달하는 방법의 개수를 더해줌
        // 예를 들어 3번째 계단까지 올라가야한다면
        // f(2) = f(1) + f(0)
        // f(3) = f(2) + f(1)
        int dp0 = 1;
        int dp1 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = dp1;
            dp1 = dp0 + dp1;
            dp0 = temp;
        }
        return dp1;
    }
}