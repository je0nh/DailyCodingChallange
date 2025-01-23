class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        String parentheses = "";
        int open = n;
        int close = n;
        dfs(parentheses, open, close);
        return ans;
    }

    private void dfs(String parentheses, int open, int close) {
        if (open == 0 && close == 0) {
            ans.add(parentheses);
            return;
        };

        if (open > 0) {
            dfs(parentheses + "(", open - 1, close);
        }
        
        if (close > open) {
            dfs(parentheses + ")", open, close - 1);
        }
    }
}