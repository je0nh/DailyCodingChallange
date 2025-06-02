class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        int wordLength = words[0].length();
        int foundWords = words.length;
        for (int i = 0; i < wordLength; i++) {
            int found = 0;
            int left = i;

            Map<String, Integer> tmp = new HashMap<>();
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String subString = s.substring(j, j + wordLength);

                if (map.containsKey(subString)) {
                    tmp.put(subString, tmp.getOrDefault(subString, 0) + 1);
                    found++;

                    while (tmp.get(subString) > map.get(subString)) {
                        String leftWord = s.substring(left, left + wordLength);
                        tmp.put(leftWord, tmp.get(leftWord) - 1);
                        found--;
                        left += wordLength;
                    }

                    if (found == foundWords) {
                        ans.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        tmp.put(leftWord, tmp.get(leftWord) - 1);
                        found--;
                        left += wordLength;
                    }
                } else {
                    tmp.clear();
                    found = 0;
                    left = j + wordLength;
                }
            }
        }
        return ans;
    }
}