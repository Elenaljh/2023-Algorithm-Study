import java.io.*;
import java.util.Stack;

/*
https://www.acmicpc.net/problem/6198
 */
public class B6198 {
    public static void main(String[] args) throws IOException {
        //초기정보
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        long count = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            while(!stack.isEmpty()) {
                if (stack.peek() <= input) {
                    stack.pop();

                } else {
                    break;
                }
            }
            count += stack.size();
            stack.push(input);
        }
        System.out.println(count);
    }
}
