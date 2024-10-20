class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();

        int wordLength = words[0].length();
        int totalWords = words.length;
        int substringLength = wordLength * totalWords;

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> tempWordCount = new HashMap<>();
            
            int wordsFound = 0;
            int left = i;

            for (int j = i; j <= s.length() - wordLength;  j += wordLength) {
                String currentWord = s.substring(j, j + wordLength);

                if (wordCount.containsKey(currentWord)) {
                    tempWordCount.put(currentWord, tempWordCount.getOrDefault(currentWord, 0) + 1);
                    wordsFound++;
                    
                    // cd ab ef ab gh
                    // ["ab", "cd", "ef", "gh", "hi"]
                    while (tempWordCount.get(currentWord) > wordCount.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        tempWordCount.put(leftWord, tempWordCount.get(leftWord) - 1);
                        wordsFound--;
                        left += wordLength;
                    }

                    if (wordsFound == totalWords) {
                        answer.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        tempWordCount.put(leftWord, tempWordCount.get(leftWord) - 1);
                        wordsFound--;
                        left += wordLength;
                    }
                } else {
                    tempWordCount.clear();
                    wordsFound = 0;
                    left = j + wordLength;
                }
            }
        }
        return answer;
    }
}