class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) return new ArrayList<>();

        Map<Character, List<String>> numMapping = new HashMap<>();
        numMapping.put('2', Arrays.asList("a", "b", "c"));
        numMapping.put('3', Arrays.asList("d", "e", "f"));
        numMapping.put('4', Arrays.asList("g", "h", "i"));
        numMapping.put('5', Arrays.asList("j", "k", "l"));
        numMapping.put('6', Arrays.asList("m", "n", "o"));
        numMapping.put('7', Arrays.asList("p", "q", "r", "s"));
        numMapping.put('8', Arrays.asList("t", "u", "v"));
        numMapping.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> ans = new ArrayList<>();
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair("", 0));
        while (!q.isEmpty()) {
            Pair<String, Integer> tmp = q.poll();
            String s = tmp.getKey();
            int idx = tmp.getValue();
            
            if (idx == n) {
                ans.add(s);
                continue;
            }

            List<String> list = numMapping.get(digits.charAt(idx));
            for (String l : list) {
                q.add(new Pair(s + l, idx + 1));
            }
        }
        return ans;
    }
}