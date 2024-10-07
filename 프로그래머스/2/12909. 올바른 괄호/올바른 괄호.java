import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean ans = false;
        
        if (s.charAt(0) == ')') {return false;}
        
        Stack<Character> stack = new Stack<>();
        
        try {
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        } catch (Exception e) {
            return false;
        }
        
        if (stack.size() == 0) {
            ans = true;
        }
        
        return ans;
    }
}