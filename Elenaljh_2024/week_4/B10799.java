// https://www.acmicpc.net/problem/10799
//쇠막대기(실버2)

import java.io.*;
import java.util.*;

public class B10799 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean lazor = true;
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
                lazor = true;
            } else if (c == ')' && lazor) {
                stack.pop();
                sum += stack.size();
                lazor = false;
            } else if (c == ')' && !lazor) {
                sum++;
                stack.pop();
            }
        }
        System.out.println(sum);
    }
}
