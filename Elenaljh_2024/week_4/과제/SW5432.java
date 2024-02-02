package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW5432 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        boolean lazor = true;
        Stack<Character> stack = new Stack<>();
        String tmp;
        int sum = 0;
        for (int t = 1; t <= testCase; t++) {
            stack = new Stack<>();
            sum = 0;
            lazor = true;
            tmp = br.readLine();
            for (int i = 0; i < tmp.length(); i++) {
                char c = tmp.charAt(i);
                if (c == '(') {
                    stack.push(c);
                    lazor = true;
                } else {
                    if (lazor) {
                        lazor = false;
                        stack.pop();
                        sum += stack.size();
                    } else {
                        sum++;
                        stack.pop();
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
