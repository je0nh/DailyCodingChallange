class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sc = s.toCharArray();

        int sIdx = sc.length;
        int idx = 0;
        for (char tc : t.toCharArray()) {
            if (idx == sIdx) {return true;}
            if (sc[idx] == tc) {
                idx++;
            }
        }

        return idx == sIdx;
    }
}