import java.util.*;
import java.io.*;


// ???? 답이 안나옴
public class B4963_upgrade {
    static String[] strs; //입력값 임시로 저장할 배열
    static int w, h = 0;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] map;
    static boolean[][] visit;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) { // 0 0이 입력되면 입력이 끝남
            strs = br.readLine().split(" ");
            w = Integer.parseInt(strs[0]);
            h = Integer.parseInt(strs[1]);

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visit = new boolean[h][w];
            count = 0;

            //지도 작성
            for (int i = 0; i < h; i++) {
                strs = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(strs[j]);
                }
            }

            //bfs 탐색
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visit[i][j] == false && map[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    // bfs: 쓰던거 계속 씀
    static void bfs (int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            visit[x][y] = true;
            q.poll();

            for (int i = 0; i < 8; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < h && cy < w) {
                    if (visit[cx][cy] == false && map[cx][cy] == 1) {
                        q.add(new int[] {cx, cy});
                        visit[cx][cy] = true;
                    }
                }
            }
        }
    }
}
