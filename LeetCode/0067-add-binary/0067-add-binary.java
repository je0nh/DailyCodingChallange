class Solution {
    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        Stack<Integer> stack = new Stack<>();

        int i = charA.length - 1;
        int j = charB.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int numA = i >= 0 ? charA[i--] - '0' : 0;
            int numB = j >= 0 ? charB[j--] - '0' : 0;

            int sum = numA + numB + carry;
            int bit = sum % 2;
            carry = sum / 2;
            
            // System.out.println(bit);
            stack.add(bit);
        }

        String ans = "";
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}