package 스터디;

import java.util.*;
import java.io.*;
/*
치즈
 */
public class B2636 {
    static int N, M, cheese, board[][];
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        cheese = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) cheese++;
            }
        }

        int cheeseLeft = 0;
        int time = 0;
        while (cheese!=0) {
            cheeseLeft = cheese;
            bfs(new boolean[N][M]);
            time++;
        }

        System.out.println(time);
        System.out.println(cheeseLeft);
    }

    static void bfs(boolean[][] visited) {
        Queue<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (board[nx][ny] == 0) {
                        q.add(new Integer[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                    if (board[nx][ny] == 1) {
                        cheese--;
                        visited[nx][ny] = true;
                        board[nx][ny] = 0;
                    }
                }
            }
        }
    }
}
