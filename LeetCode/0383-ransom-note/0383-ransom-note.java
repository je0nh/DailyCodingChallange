class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char d = ransomNote.charAt(i);

            if (!map.containsKey(d) || map.get(d) <= 0) return false;

            map.put(d, map.getOrDefault(d, 0) - 1);
        }
        
        return true;
    }
}