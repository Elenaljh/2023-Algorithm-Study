import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/10845
 */
public class B10845 {
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int back;

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
        String command = st.nextToken();


        switch (command) {
            case "push":
                back = Integer.parseInt(st.nextToken());
                q.add(back);
                break;
            case "pop":
                if (!q.isEmpty()) {
                    sb.append(q.poll()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
                break;
            case "size":
                sb.append(q.size()).append("\n");
                break;
            case "empty":
                if (q.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                break;
            case "front":
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }
                break;
            case "back":
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(back).append("\n");
                }
                break;
            default:
                System.out.println("error");
        }
    }
}
