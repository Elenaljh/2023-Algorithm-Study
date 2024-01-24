import java.util.*;
import java.io.*;

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek()[0] < input) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (stack.isEmpty()) {
               sb.append(0).append(" ");
            } else {
                sb.append(stack.peek()[1]).append(" ");
            }
            stack.push(new Integer[]{input, i+1});
        }
        System.out.println(sb);
    }
}
