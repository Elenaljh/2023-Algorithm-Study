package BFS;

import java.io.*;
import java.util.*;

/*
유기농 배추
*/

public class B1012 {
    static int m, n, k;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j]==1) {
                        result++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int x, int y) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        q.add(new Integer[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
