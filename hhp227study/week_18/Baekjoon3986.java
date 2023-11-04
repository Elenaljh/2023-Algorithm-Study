/**
좋은 단어
https://www.acmicpc.net/problem/3986
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String input = scanner.next();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);

                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            if (stack.isEmpty()) answer++;
        }
        System.out.println(answer);
        scanner.close();
    }
}
