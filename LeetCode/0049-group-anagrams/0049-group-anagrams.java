class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> answer = new HashMap<>();
        for (String s : strs) {
            char[] cList = s.toCharArray();
            Arrays.sort(cList);
            String sortedWord = new String(cList);

            if(!answer.containsKey(sortedWord)) {
                answer.put(sortedWord, new ArrayList<>());
            }

            answer.get(sortedWord).add(s);
        }

        return new ArrayList<>(answer.values());
    }
}