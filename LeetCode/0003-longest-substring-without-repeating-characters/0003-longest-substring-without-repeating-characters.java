class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int start = 0;

        boolean[] check = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (check[c]) {
                check[s.charAt(start)] = false;
                start++;
            }
            check[c] = true;
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}