/* https://www.acmicpc.net/problem/4949 */
import java.io.*;
import java.util.*;
public class B4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence;
        Loop1:
        while (!(sentence = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                if (c == '.') break;
                if (c == '(') {
                    stack.push(c);
                    continue;
                }
                if (c == '[') {
                    stack.push(c);
                    continue;
                }
                if (stack.isEmpty() && (c == ')' || c == ']')) {
                    System.out.println("no");
                    continue Loop1;
                }
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                        continue;
                    } else {
                        System.out.println("no");
                        continue Loop1;
                    }
                }
                if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        System.out.println("no");
                        continue Loop1;
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

}
