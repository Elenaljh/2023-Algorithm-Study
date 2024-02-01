import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
미로탐색(실버1)
https://www.acmicpc.net/problem/2178
 */
public class B2178 {
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //행
        m = Integer.parseInt(st.nextToken()); //열
        dist = new int[n][m];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        //탐색
        bfs();

        System.out.println(dist[n-1][m-1] + 1);

    }

    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        int x = 0, y = 0;

        //초기화
        q.add(new Integer[]{x, y});
        dist[x][y] = 0;
        int distance = 0;

        //탐색
        while (!q.isEmpty()) {
            Integer[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (dist[nx][ny] == -1 && map[nx][ny] == 1) {
                        q.add(new Integer[]{nx, ny});
                        dist[nx][ny] = dist[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
