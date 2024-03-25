import java.util.*;
import java.io.*;
public class B13549_숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //수빈이 위치
        int k = Integer.parseInt(st.nextToken()); //동생 위치
        int[] arr = new int[100_001];
        Deque<Integer[]> dq = new ArrayDeque<>();
        dq.add(new Integer[]{n, 0});
        boolean[] visited = new boolean[100_001];

        int count = 0;
        while (!dq.isEmpty()) {
            Integer[] now = dq.poll();
            int np = now[0];
            count = now[1];

            if (np == k) {
                break;
            }

            visited[np] = true;
            if (np * 2 <= 100_000 && !visited[np*2]) {
                dq.addFirst(new Integer[]{np*2, count});
            }
            if (np < k && np+1 <= 100_000 && !visited[np+1]) {
                dq.offerLast(new Integer[]{np+1, count+1});
            }
            if (np-1 >= 0 && !visited[np-1]) {
                dq.offerLast(new Integer[]{np-1, count+1});
            }
        }

        System.out.println(count);
    }

}
