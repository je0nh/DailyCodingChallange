class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            counter[sc - 'a']++;
            counter[tc - 'a']--;
        }

        for (int c : counter) {
            if (c != 0) return false;
        }

        return true;
    }
}