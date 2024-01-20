/**
쇠막대기
https://www.acmicpc.net/problem/10799
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (i > 0) answer += s.charAt(i - 1) == '(' ? stack.size() - 1 : 1;
                    stack.pop();
                    break;
            }
        }
        System.out.println(answer);
        scanner.close();
    }
}
