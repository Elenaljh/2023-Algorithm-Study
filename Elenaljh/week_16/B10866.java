import java.io.*;
import java.util.*;

public class B10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int a;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front" -> dq.addFirst(Integer.parseInt(st.nextToken()));
                case "push_back" -> dq.addLast(Integer.parseInt(st.nextToken()));
                case "pop_front" -> {
                    a = (dq.isEmpty()) ? -1 : dq.pollFirst();
                    sb.append(a).append('\n');
                }
                case "pop_back" -> {
                    a = (dq.isEmpty()) ? -1 : dq.pollLast();
                    sb.append(a).append('\n');
                }
                case "size" -> sb.append(dq.size()).append('\n');
                case "empty" -> {
                    a = (dq.isEmpty()) ? 1 : 0;
                    sb.append(a).append('\n');
                }
                case "front" -> {
                    a = (dq.isEmpty()) ? -1 : dq.peekFirst();
                    sb.append(a).append('\n');
                }
                case "back" -> {
                    a = (dq.isEmpty()) ? -1 : dq.peekLast();
                    sb.append(a).append('\n');
                }
            }
        }
        System.out.println(sb);

    }
}
