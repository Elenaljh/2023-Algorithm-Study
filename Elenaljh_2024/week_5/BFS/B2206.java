package BFS;
import java.io.*;
import java.util.*;

public class B2206 {
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static Queue<Integer[]> q = new LinkedList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        //오리지널
        dist[0][0] = 0;
        q.add(new Integer[]{0, 0});
        bfs();

        //벽부수기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0; //벽부수기
                    for (int a = 0; a < n; a++) { //거리맵 원상복구
                        Arrays.fill(dist[a], -1);
                    }
                    dist[0][0] = 0; //초기세팅
                    q.add(new Integer[]{0, 0});
                    bfs();
                    map[i][j] = 1;
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }


    }

    static void bfs() {
        while(!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (dist[nx][ny] == -1 && map[nx][ny] == 0) {
                        dist[nx][ny] = dist[now[0]][now[1]] + 1;
                        q.add(new Integer[]{nx, ny});
                    }
                }
            }
        }
        int destination = dist[n-1][m-1];
        if (destination != -1) {
            min = Integer.min(min, destination+1);
        }
    }
}
