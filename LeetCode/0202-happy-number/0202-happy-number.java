class Solution {
    public boolean isHappy(int n) {
        List<Integer> map = new ArrayList<>();

        while (true) {
            int sum = 0;
            while (n > 0) {
                int num = n % 10;
                sum += num * num;
                n /= 10;
            }
            
            // System.out.println(sum);

            if (map.contains(sum)) {
                return false;
            }

            if (sum == 1) {
                return true;
            }
            map.add(sum);
            n = sum;
        }
    }
}