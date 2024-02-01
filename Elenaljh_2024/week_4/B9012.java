//https://www.acmicpc.net/problem/9012
import java.io.*;
import java.util.*;

public class B9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack;

        Loop1:
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            stack = new Stack<>();
            for (int j = 0; j < tmp.length(); j++) {
                char c = tmp.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else if (stack.isEmpty()) {
                    sb.append("NO").append("\n");
                    continue Loop1;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
