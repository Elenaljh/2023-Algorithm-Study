import java.io.*;
import java.util.*;

public class B3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            for (int j = 0; j < st.length(); j++) {
                char input = st.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(input);
                } else if (stack.peek().equals(input)) {
                    stack.pop();
                } else {
                    stack.push(input);
                }
            }
            if (stack.isEmpty()) {
                count++;
            }
            stack.removeAllElements();
        }
        System.out.println(count);
    }
}
