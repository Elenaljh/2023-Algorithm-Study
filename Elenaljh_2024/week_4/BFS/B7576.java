package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/7576
토마토
 */
public class B7576 {
    static int n, m; //n: 행, m: 열
    static int[][] days;
    static int[][] tomatoes;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Queue<Integer[]> q = new LinkedList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomatoes = new int[n][m];
        days = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(days[i], -1);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    q.add(new Integer[]{i, j});
                    days[i][j] = 0;
                }
            }
        }


        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j] == 0 && days[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);

    }

    static void bfs() {
        while (!q.isEmpty()) {
            Integer[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (days[nx][ny] == -1 && tomatoes[nx][ny] == 0) {
                        q.add(new Integer[]{nx, ny});
                        days[nx][ny] = days[now[0]][now[1]] + 1;
                        max = Math.max(days[nx][ny], max);
                    }
                }
            }
        }
    }
}
