package BFS;

import java.io.*;
import java.util.*;
public class B2206_1 {
    static int n, m;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static Queue<Integer[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[2][n][m];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            Arrays.fill(visited[0][i], -1);
            Arrays.fill(visited[1][i], -1);
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }
        q.add(new Integer[]{0, 0, 0});
        visited[0][0][0] = 0;
        visited[1][0][0] = 0;

        bfs();

        int dist1 = visited[0][n-1][m-1];
        int dist2 = visited[1][n-1][m-1];
        if (dist1 == -1 && dist2 == -1) {
            System.out.println(-1);
        } else if (dist1 == -1) {
            System.out.println(dist2 + 1);
        } else if (dist2 == -1) {
            System.out.println(dist1 + 1);
        } else {
            System.out.println(Integer.min(dist1+1, dist2+1));
        }
    }
    static void bfs() {
        while(!q.isEmpty()) {
            Integer[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[2] + dy[i];
                int nz = now[0];
                if (nx >= 0 && nx < n && ny >=0 && ny < m) {
                    if (visited[nz][nx][ny] == -1 && map[nx][ny] == 0) {
                        q.add(new Integer[]{nz, nx, ny});
                        visited[nz][nx][ny] = visited[now[0]][now[1]][now[2]] + 1;
                    }
                    if (nz == 0 && map[nx][ny] == 1) {
                        q.add(new Integer[]{1, nx, ny});
                        visited[1][nx][ny] = visited[0][now[1]][now[2]] + 1;
                    }
                }
            }
        }
    }
}
