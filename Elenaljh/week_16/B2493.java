import java.io.*;
import java.util.*;

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer[]> stack1 = new Stack<>();
        Stack<Integer[]> stack2 = new Stack<>();
        int[] result = new int[n+1];
        int index;
        int a;

        for (int i = 1; i < n+1; i++) {
            a = Integer.parseInt(st.nextToken());
            Integer[] b = {a, i};
            stack1.push(b);
        }

        while (!stack1.isEmpty()) {
            if (stack2.isEmpty() || stack2.peek()[0] > stack1.peek()[0]) {
                stack2.push(stack1.pop());
            } else if (stack2.peek()[0] < stack1.peek()[0]) {
                index = stack2.pop()[1];
                result[index] = stack1.peek()[1];
            }
        }

        for (int i = 1; i < n+1; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
