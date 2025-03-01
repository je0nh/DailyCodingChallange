class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int reverse = 0;
        int copy = x;
        
        while (copy > 0) {
            reverse = (reverse * 10) + (copy % 10);
            copy /= 10;
        }

        // System.out.println(x);
        // System.out.println(reverse);
        return x == reverse;
    }
}