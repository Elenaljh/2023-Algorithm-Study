import java.io.*;
import java.util.*;

public class B18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int a;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    a = (dq.isEmpty())? -1 : dq.pollFirst();
                    sb.append(a).append('\n');
                    break;

                case "size":
                    sb.append(dq.size()).append('\n');
                    break;

                case "empty":
                    a = (dq.isEmpty())? 1 : 0;
                    sb.append(a).append('\n');
                    break;

                case "front":
                    a = (dq.isEmpty())? -1 : dq.peekFirst();
                    sb.append(a).append('\n');
                    break;

                case "back":
                    a = (dq.isEmpty())? -1 : dq.peekLast();
                    sb.append(a).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
