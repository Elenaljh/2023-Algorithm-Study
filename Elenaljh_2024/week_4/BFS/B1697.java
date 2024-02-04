package BFS;
/*
숨바꼭질
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }
        int[] subin = new int[100100];
        Arrays.fill(subin, -1);
        subin[n] = 0;
        int[] dx = new int[]{-1, 1, 2};
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int i = 0; i < 3; i++) {
                int nx = i == 2 ? x*dx[i] : x+dx[i];
                if (nx >= 0 && nx < 100100) {
                    if (subin[nx] == -1) {
                        q.add(nx);
                        subin[nx] = subin[x] + 1;
                        if (nx == k) {
                            System.out.println(subin[nx]);
                            return;
                        }
                    }
                }
            }
        }
    }
}
