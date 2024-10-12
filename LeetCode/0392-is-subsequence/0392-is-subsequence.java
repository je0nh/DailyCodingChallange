class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {return true;}

        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            System.out.println("s idx: " + sIndex + ", t idx: " + tIndex);
            if (s.charAt(sIndex) == t.charAt(tIndex++)) {
                sIndex++;
            }
        }
        
        System.out.println("total sIndex: " + sIndex);

        if (sIndex == s.length()) {return true;}

        return false;
    }
}