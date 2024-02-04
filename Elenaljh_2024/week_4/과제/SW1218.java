package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack;

        Loop1:
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            String str = br.readLine();
            stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '[' || c == '{' || c == '<') {
                    stack.push(c);
                    continue;
                }
                if (stack.isEmpty()) {
                    sb.append("#").append(t).append(" ").append(0).append("\n");
                    continue Loop1;
                }
                if (c == ')' && stack.peek()=='(') {
                    stack.pop();
                } else if (c==')') {
                    sb.append("#").append(t).append(" ").append(0).append("\n");
                    continue Loop1;
                }
                if (c == ']' && stack.peek()=='[') {
                    stack.pop();
                } else if (c==']') {
                    sb.append("#").append(t).append(" ").append(0).append("\n");
                    continue Loop1;
                }
                if (c == '}' && stack.peek()=='{') {
                    stack.pop();
                } else if (c=='}') {
                    sb.append("#").append(t).append(" ").append(0).append("\n");
                    continue Loop1;
                }
                if (c == '>' && stack.peek()=='<') {
                    stack.pop();
                } else if (c=='>') {
                    sb.append("#").append(t).append(" ").append(0).append("\n");
                    continue Loop1;
                }
            }
            sb.append("#").append(t).append(" ").append(1).append("\n");
        }
        System.out.println(sb);
    }
}
