import java.util.*;
import java.io.*;

public class B10828 {
    public static Stack<Integer> stack = new Stack<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            work(br.readLine());
        }
        System.out.println(sb);
    }

    static void work(String str) {
        StringTokenizer st = new StringTokenizer(str);
        String go = st.nextToken();
        switch (go) {
            case "push":
                int element = Integer.parseInt(st.nextToken());
                stack.push(element);
                break;
            case "pop":
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
                break;
            case "size":
                sb.append(stack.size()).append("\n");
                break;
            case "empty":
                if (stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
                break;
            case "top":
                if (stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
                break;
            default:
                System.out.println("error");
        }
    }
}
