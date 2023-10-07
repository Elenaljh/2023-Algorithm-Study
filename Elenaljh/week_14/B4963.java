import java.util.*;
import java.io.*;


// ???? 답이 안나옴
public class B4963 {
    static String[] strs; //입력값 임시로 저장할 배열
    static int w, h = 0;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] map;
    static boolean[][] visit;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strs = br.readLine().split(" ");
        w = Integer.parseInt(strs[0]);
        h = Integer.parseInt(strs[1]);

        while (w != 0 && h != 0) { // 0 0이 입력되면 입력이 끝남
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
                    if (visit[i][j] == false) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.print("\n" + count);

            strs = br.readLine().split(" ");
            w = Integer.parseInt(strs[0]);
            h = Integer.parseInt(strs[1]);
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
                    if (visit[cx][cy] == false && map[cx][cy] == 1 && !IsContain(q, x, y)) {
                        q.add(new int[] {cx, cy});
                        visit[cx][cy] = true;
                    }
                }
            }
        }
    }

    static boolean IsContain(Queue<int[]> q, int x, int y) {
        for (int[] a : q) {
            if (x == a[0] && y == a[1]) {
                return true;
            }
        }
        return false;
    }
}
