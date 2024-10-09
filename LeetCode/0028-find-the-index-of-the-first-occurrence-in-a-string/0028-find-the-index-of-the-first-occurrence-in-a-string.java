class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {return -1;}

        for (int i = 0; i < haystack.length(); i++) {
            int n = i + needle.length();
            String haystackSubstring;
            
            try {
                haystackSubstring = haystack.substring(i, i + needle.length());
            } catch (Exception e) {
                haystackSubstring = haystack.substring(i, haystack.length());
            }

            if (haystackSubstring.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}