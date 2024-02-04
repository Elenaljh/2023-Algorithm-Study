import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/10866
 */
public class B10866 {
    static Deque<Integer> dq = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            work(command);
        }

        System.out.println(sb);
    }

    static void work(String str) {
        StringTokenizer st = new StringTokenizer(str);
        String command = st.nextToken();
        int num;
        switch (command) {
            case "push_back":
                num = Integer.parseInt(st.nextToken());
                dq.addLast(num);
                break;
            case "push_front":
                num = Integer.parseInt(st.nextToken());
                dq.addFirst(num);
                break;
            case "pop_front":
                if (dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.pollFirst()).append("\n");
                break;
            case "pop_back":
                if (dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.pollLast()).append("\n");
                break;
            case "size":
                sb.append(dq.size()).append("\n");
                break;
            case "empty":
                if (dq.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
                break;
            case "front":
                if (dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.peekFirst()).append("\n");
                break;
            case "back":
                if (dq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(dq.peekLast()).append("\n");
                break;
        }
    }
}
