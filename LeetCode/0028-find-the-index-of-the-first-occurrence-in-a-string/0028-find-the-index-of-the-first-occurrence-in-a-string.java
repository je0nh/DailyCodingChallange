class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();

        int idx = 0;
        int needleLength = needle.length();
        while (idx <= n - needleLength) {
            String s = haystack.substring(idx, idx + needleLength);
            // System.out.println(s);
            if (s.equals(needle)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }
}