class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");

        List<String> stack = new ArrayList<>();
        for (String s : split) {
            if (s.equals("") || s.equals(".")) continue;

            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    int idx = stack.size() - 1;
                    stack.remove(idx);
                }
                continue;
            }

            stack.add(s);
        }

        

        String ans = "/";
        if (stack.isEmpty()) return ans;

        for (int i = 0; i < stack.size(); i++) {
            if (i == stack.size() - 1) {
                ans += stack.get(i);
                break;
            }

            ans += stack.get(i) + "/";
        }
        return ans;
    }
}