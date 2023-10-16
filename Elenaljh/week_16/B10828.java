import java.io.*;
import java.util.*;

public class B10828 {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String st;
        for (int i = 0; i < n; i++) {
            st = br.readLine();
            command(st);
        }
    }

    static void command(String st) {
        if (st.contains("push")) {
            int number = Integer.parseInt(st.split(" ")[1]);
            stack.push(number);
            return;
        }

        switch (st) {
            case "pop":
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                if (!stack.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
                break;
            case "top":
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
                break;
        }
    }
}
