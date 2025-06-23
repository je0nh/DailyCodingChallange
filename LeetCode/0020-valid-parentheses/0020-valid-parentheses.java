class Solution {
    private Map<Character, Character> map = new HashMap<>();

    public Solution() {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}