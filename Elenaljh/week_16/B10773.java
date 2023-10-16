import java.io.*;
import java.util.*;

public class B10773 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int input;
        int count = 0;

        for (int i = 0; i < k; i++) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                count -= stack.pop();
            } else {
                stack.push(input);
                count += input;
            }
        }

        System.out.println(count);
    }
}
