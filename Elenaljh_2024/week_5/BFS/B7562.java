package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {
    static int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = new int[]{1, -1, -2, 2, -2, 2, 1, -1};
    static int n; //체스판 길이ㅣ
    static int cx, cy, ox, oy;
    static int[][] count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());



        //테스트 케이스
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            count = new int[n][n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(count[j], -1);
            }
            st = new StringTokenizer(br.readLine());
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());
            count[cx][cy] = 0;
            st = new StringTokenizer(br.readLine());
            ox = Integer.parseInt(st.nextToken());
            oy = Integer.parseInt(st.nextToken());

            bfs();
        }
        System.out.println(sb);

    }
    static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{cx, cy});

        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (count[nx][ny] == -1) {
                        q.add(new Integer[]{nx, ny});
                        count[nx][ny] = count[now[0]][now[1]] + 1;
                        if (nx == ox && ny == oy) {
                            sb.append(count[nx][ny]).append("\n");
                            return;
                        };
                    }
                }
            }
        }
        sb.append(0).append("\n");
    }
}
