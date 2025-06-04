class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (smap.containsKey(sc)) {
                if (smap.get(sc) != tc) return false;
            } else {
                smap.put(sc, tc);
            }

            if (tmap.containsKey(tc)) {
                if (tmap.get(tc) != sc) return false;
            } else {
                tmap.put(tc, sc);
            }
        }
        return true;
    }
}