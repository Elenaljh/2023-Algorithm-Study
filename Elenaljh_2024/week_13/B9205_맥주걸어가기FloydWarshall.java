import java.io.*;
import java.util.*;
public class B9205_맥주걸어가기FloydWarshall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer[]> nodes;
        boolean[][] connected;

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            nodes = new ArrayList<>();

            for (int i = 0; i < N+2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                nodes.add(new Integer[]{x, y});
            }

            connected = new boolean[N+2][N+2];

            //1000m 이하 거리의 두 노드를 찾고, 해당 경로에 true 처리
            for (int i = 0; i < N+2; i++) {
                for (int j = i+1; j < N+2; j++) {
                    if (length(nodes.get(i), nodes.get(j)) <= 1000) {
                        connected[i][j] = connected[j][i] = true;
                    }
                }
            }

            floyd(connected, N);

            sb.append((connected[0][N+1] ? "happy" : "sad") + '\n');
        }
        System.out.println(sb);
    }

    static int length(Integer[] a, Integer[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }

    static void floyd(boolean[][] connected, int N) {
        for (int k = 0; k < N+2; k++) {
            for (int i = 0; i < N+2; i++) {
                for (int j = 0; j < N+2; j++) {
                    if (connected[i][k] && connected[k][j]) {
                        connected[i][j] = true;
                    }
                }
            }
        }
    }
}
