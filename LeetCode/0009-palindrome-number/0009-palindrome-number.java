class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        // if (x < 10) return true;

        // int log = (int) Math.log10(x);
        // if (log % 2 != 0) return false;

        String s = Integer.toString(x);
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            // System.out.printf("left: %s, right: %s", s.charAt(left), s.charAt(right));
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}