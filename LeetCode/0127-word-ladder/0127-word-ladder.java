class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Queue<String[]> q = new LinkedList<>();
        q.add(new String[]{beginWord, "0"});
        List<String> visited = new ArrayList<>();

        while (!q.isEmpty()) {
            String[] tmp = q.poll();
            String w = tmp[0];
            int count = Integer.parseInt(tmp[1]);

            if (w.equals(endWord)) return count + 1;

            for (String s : wordList) {
                if (checkWord(w, s) && !visited.contains(s)) {
                    q.add(new String[]{s, Integer.toString(count + 1)});
                    visited.add(s);
                }
            }            
        }
        return 0;
    }

    private boolean checkWord(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        if (count == 1) return true;
        return false;
    }
}