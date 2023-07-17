import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty() || c == '(') {
                stack.push(c);
            } else {
                if(stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }  
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
