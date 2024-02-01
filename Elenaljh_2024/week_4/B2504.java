import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
괄호의 값 (골드5)
https://www.acmicpc.net/problem/2504
 */
public class B2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int tmp = 1;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                tmp *= 2;
                stack.push(c);
            } else if (c == '[') {
                tmp *= 3;
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                } else if (str.charAt(i-1) == '(') {
                    sum += tmp;
                    tmp /= 2;
                    stack.pop();
                } else if (stack.peek() == '(') {
                    tmp /= 2;
                    stack.pop();
                } else {
                    System.out.println(0);
                    return;
                }
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                } else if (str.charAt(i-1) == '[') {
                    sum += tmp;
                    tmp /= 3;
                    stack.pop();
                } else if (stack.peek() == '[') {
                    tmp /= 3;
                    stack.pop();
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }
    }
}
