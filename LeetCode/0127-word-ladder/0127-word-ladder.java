class Solution {
    private HashMap<String, List<String>> graph = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        createGraph(beginWord, wordList);
        
        Queue<String[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(new String[]{beginWord, "1"});
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            String[] current = queue.poll();
            String word = current[0];
            int steps = Integer.parseInt(current[1]);
            
            if (word.equals(endWord)) {
                return steps;
            }
            
            for (String neighbor : getWord(word)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new String[]{neighbor, Integer.toString(steps + 1)});
                }
            }
        }
        return 0;
    }

    private void createGraph(String word, List<String> wordList) {
        Set<String> list = new HashSet<>(wordList);
        list.add(word);

        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                String pattern = s.substring(0, i) + "*" + s.substring(i+1);
                graph.putIfAbsent(pattern, new ArrayList<>());
                graph.get(pattern).add(s);
            }
        }
    }

    private List<String> getWord(String word) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            String pattern = word.substring(0, i) + "*" + word.substring(i+1);
            if (graph.containsKey(pattern)) {
                neighbors.addAll(graph.get(pattern)); // 이웃 단어를 추가
            }
        }
        return neighbors;
    }
}