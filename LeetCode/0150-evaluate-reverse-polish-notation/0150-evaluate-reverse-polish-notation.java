class Solution {
    private String[] operators = new String[]{"+", "-", "*", "/"};

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            int num = 0;
            int left = 0;
            int right = 0;
            if (token.equals("+")) {
                right = stack.pop();
                left = stack.pop();
                num = left + right;
            } else if (token.equals("-")) {
                right = stack.pop();
                left = stack.pop();
                num = left - right;
            } else if (token.equals("*")) {
                right = stack.pop();
                left = stack.pop();
                num = left * right;
            } else if (token.equals("/")) {
                right = stack.pop();
                left = stack.pop();
                num = left / right;
            } else {
                num = Integer.parseInt(token);
            }
            // System.out.println(num);
            stack.add(num);
        }
        return stack.pop();
    }
}