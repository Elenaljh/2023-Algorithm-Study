import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//https://www.acmicpc.net/problem/3986
public class B3986 {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            stack = new Stack<>();
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char tmp = line.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(tmp);
                } else if (stack.peek() == tmp) {
                    stack.pop();
                } else if (stack.peek() != tmp) {
                    stack.push(tmp);
                }
            }
            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
