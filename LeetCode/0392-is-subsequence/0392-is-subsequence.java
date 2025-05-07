class Solution {
    public boolean isSubsequence(String s, String t) {
        int check = 0;
        
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            if (check < s.length() && s.charAt(check) == c) {
                check++;
            }
        }
        return check == s.length();
    }
}