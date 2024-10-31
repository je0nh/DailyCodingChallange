class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> patternTable = new HashMap<>();
        String[] sSplit = s.split(" ");
        if (pattern.length() != sSplit.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String ss = sSplit[i];
            if (patternTable.containsValue(ss)) {
                continue;
            }
            patternTable.put(c, ss);
        }

        // System.out.println(patternTable.toString());

        for (int i = 0; i < pattern.length(); i++) {
            String answer = patternTable.get(pattern.charAt(i));
            if (answer == null || !answer.equals(sSplit[i])) return false;
        }

        return true;
    }
}