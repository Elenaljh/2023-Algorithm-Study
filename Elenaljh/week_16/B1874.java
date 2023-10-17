import java.io.*;
import java.util.*;

public class B1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int j;
        int input = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            j = Integer.parseInt(br.readLine());
            while (input <= j) {
                stack.push(input);
                input++;
                sb.append("+\n");
            }
            if (stack.peek() == j) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}